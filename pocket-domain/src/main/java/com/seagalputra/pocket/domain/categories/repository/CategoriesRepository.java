package com.seagalputra.pocket.domain.categories.repository;

import com.seagalputra.pocket.domain.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryId(String categoryId);
}
