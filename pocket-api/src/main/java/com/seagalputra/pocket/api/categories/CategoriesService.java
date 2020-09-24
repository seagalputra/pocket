package com.seagalputra.pocket.api.categories;

import com.seagalputra.pocket.api.categories.request.CreateCategoryRequest;

public interface CategoriesService {

    void addNewCategory(CreateCategoryRequest request);
}
