package com.main.project.web;

import com.main.project.entity.Products;
import com.main.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductResource {
    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productservice;

    public ProductResource(ProductService productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/{categoryId}")
    public List<Products> getAllProducts(@PathVariable(value = "categoryId") String categoryId){
        log.debug("REST request to get Products : {}", categoryId);
        return productservice.findAll(categoryId);
    }

    @GetMapping("/{categoryId}/{productId}")
    public Optional<Products> getProductById(@PathVariable (value = "categoryId") String categoryId,
                                             @PathVariable (value = "productId") String productId){
        log.debug("REST request to get Product : {}", categoryId,productId );
        return productservice.findOne(categoryId,productId);
    }
}