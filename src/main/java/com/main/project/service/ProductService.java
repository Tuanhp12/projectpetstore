package com.main.project.service;

import com.main.project.entity.Categories;
import com.main.project.entity.Products;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Transactional(readOnly = true)
    public List<Products> findAll(String categoryId) {
        log.debug("Request to get all products");
        categoryService.findByCategoryIdentifier(categoryId);
        return productRepository.findByCategoryIdentifier(categoryId);
    }

    @Transactional(readOnly = true)
    public Products findOne(String categoryId, String productId) {
        log.debug("Request to get product : {}", productId);

        List<Products> products = findAll(categoryId);
        for(Products product: products){
            if(product.getProductIdentifier().equals(productId)){
                return productRepository.findByProductIdentifier(productId);
            }
        }
        throw new ResourceNotFoundException("Product Identifier " + productId + " not found");
    }

    @Transactional(readOnly = true)
    public Products findByIdentifier(String id){
        return productRepository.findByProductIdentifier(id);
    }

    public Products saveOrUpdateProduct(String categoryIdentifier,Products product){
        product.setProductIdentifier(RandomIdService.returnRandomId(product.getName()));
        if(product.getPrice() < 0){
            throw new ResourceNotFoundException("Product price cant lower than 0");
        }
        if(product.getCurrentQuantity() > 0){
            product.setStatus("Stocking");
        }
        else if(product.getCurrentQuantity() < 0){
            throw new ResourceNotFoundException("Product quantity cant lower than 0");
        }
        else {
            product.setStatus("Out Stock");
        }
        List<Categories> categories = categoryService.findAll();
        int check = 0;
        for (Categories category: categories){
            if(category.getCategoryIdentifier().contains(categoryIdentifier)) {
                product.setCategoryIdentifier(category.getCategoryIdentifier());
                product.setCategory(category);
                check = 1;
            }
        }
        if(check == 0){
            throw new ResourceNotFoundException("Cant not find type product in categories");
        }
        return productRepository.save(product);
    }
}

