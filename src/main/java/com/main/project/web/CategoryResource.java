package com.main.project.web;

import com.main.project.entity.Categories;
import com.main.project.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin
public class CategoryResource {
    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Categories> getAllCategories(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Bands");
        return categoryService.findAll();
    }

    @GetMapping("/{categoryIdentifier}")
    public Optional<Categories> getCategory(@PathVariable(value = "categoryIdentifier") String id) {
        log.debug("REST request to get Band : {}", id);
        return categoryService.findByCategoryIdentifier(id);
    }
}
