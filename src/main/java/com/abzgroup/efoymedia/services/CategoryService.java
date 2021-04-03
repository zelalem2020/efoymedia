package com.abzgroup.efoymedia.services;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    List<CategoryDTO> addCategories(List<CategoryDTO> categories);

}
