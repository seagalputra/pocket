package com.seagalputra.pocket.api.categories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateCategoryRequest {

    @JsonIgnore
    private String categoryId;
    @JsonIgnore
    private String userId;
    private String title;
    private String description;
}
