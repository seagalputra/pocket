package com.seagalputra.pocket.domain.categories.service;

import com.seagalputra.pocket.api.categories.CategoriesService;
import com.seagalputra.pocket.api.categories.request.CreateCategoryRequest;
import com.seagalputra.pocket.domain.DomainConfiguration;
import com.seagalputra.pocket.domain.categories.entity.Category;
import com.seagalputra.pocket.domain.categories.repository.CategoriesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DomainConfiguration.class)
@ActiveProfiles("test")
class CategoriesServiceImplTest {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Test
    void shouldAddCategories() {

        String userId = UUID.randomUUID().toString();
        String categoryId = UUID.randomUUID().toString();
        String title = "Online Purchase";
        String description = "Purchasing with online payment";

        CreateCategoryRequest request = CreateCategoryRequest.builder()
                .categoryId(categoryId)
                .userId(userId)
                .title(title)
                .description(description)
                .build();

        categoriesService.addNewCategory(request);

        Category actual = categoriesRepository.findByCategoryId(categoryId)
                .orElseGet(() -> Category.builder().build());

        assertEquals(userId, actual.getUserId());
        assertEquals(categoryId, actual.getCategoryId());
        assertEquals(title, actual.getTitle());
        assertEquals(description, actual.getDescription());
    }
}