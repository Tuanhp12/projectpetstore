package com.main.project.repository;

import com.main.project.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByCategoryId(Long categoryId);

    Optional<Products> findByIdAndCategoryId(Long categoryId, Long productId);

    List<Products> findByCategoryIdentifier(String id);

    Optional<Products> findByProductIdentifier(String id);

    Optional<Products> findByCategoryIdentifierAndProductIdentifier(String category, String productId);
}