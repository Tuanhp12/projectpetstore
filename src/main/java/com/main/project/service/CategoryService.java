package com.main.project.service;

import com.main.project.entity.Categories;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Categories> findAll() {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Categories> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Categories> findByCategoryIdentifier(String id) {
        log.debug("Request to get Category : {}", id);
        List<Categories> categories = findAll();
        for(Categories category: categories){
            if(category.getCategoryIdentifier().equals(id)){
                return categoryRepository.findByCategoryIdentifier(id);
            }
        }
        throw new ResourceNotFoundException("Category Identifier " + id + " not found");
    }
}
