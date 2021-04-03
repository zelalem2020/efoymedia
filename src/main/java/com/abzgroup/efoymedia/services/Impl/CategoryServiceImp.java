package com.abzgroup.efoymedia.services.Impl;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.model.Category;
import com.abzgroup.efoymedia.dal.repositories.CategoryRepo;
import com.abzgroup.efoymedia.services.CategoryService;
import com.abzgroup.efoymedia.utilities.MultiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private MultiMapper multiMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        return multiMapper.mapList(categoryList, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> addCategories(List<CategoryDTO> categoryDTOList) {

        //Convert dto to model
        List<Category> categoryListToSave = multiMapper.mapList(categoryDTOList, Category.class);

        //Save
        List<Category> categoryListSaved = categoryRepo.saveAll(categoryListToSave);

        //Convert back saved model to dto
        List<CategoryDTO> categoryListSavedDTO = multiMapper.mapList(categoryListSaved, CategoryDTO.class);

        return categoryListSavedDTO;

    }


}
