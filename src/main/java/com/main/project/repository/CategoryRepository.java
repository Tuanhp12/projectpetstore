package com.main.project.repository;

import com.main.project.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
    Optional<Categories> findByCategoryIdentifier(String categoryIdentifier);

    @Query("select c from Categories c where c.type = :type")
    Optional<Categories> findByCategoryType(String type);
}