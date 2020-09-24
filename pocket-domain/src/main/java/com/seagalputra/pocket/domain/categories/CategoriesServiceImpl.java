package com.seagalputra.pocket.domain.categories;

import com.seagalputra.pocket.api.categories.CategoriesService;
import com.seagalputra.pocket.api.categories.request.CreateCategoryRequest;
import com.seagalputra.pocket.domain.categories.entity.Category;
import com.seagalputra.pocket.domain.categories.repository.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public void addNewCategory(CreateCategoryRequest request) {
        Category category = Category.builder()
                .categoryId(request.getCategoryId())
                .userId(request.getUserId())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        categoriesRepository.save(category);
    }
}
