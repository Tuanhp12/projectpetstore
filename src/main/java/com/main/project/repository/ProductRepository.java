package com.main.project.repository;

import com.main.project.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByCategoryId(Long categoryId);

    Optional<Products> findByIdAndCategoryId(Long categoryId, Long productId);

    List<Products> findByCategoryIdentifier(String id);

    @Query("select p from Products p where p.productIdentifier = :id")
    Products findByProductIdentifier(@Param("id") String id);

    Optional<Products> findByCategoryIdentifierAndProductIdentifier(String category, String productId);
}