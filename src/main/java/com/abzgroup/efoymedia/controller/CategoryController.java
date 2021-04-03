package com.abzgroup.efoymedia.controller;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.dtos.requestDtos.RequestDTO;
import com.abzgroup.efoymedia.dal.dtos.responseDtos.ResponseDTO;
import com.abzgroup.efoymedia.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



    @PostMapping(value = "/category")
    public ResponseDTO addCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseDTO();
    }

    @GetMapping(value = "/categories")
    public ResponseDTO getAllCategories(@RequestParam(defaultValue = "100") int pageSize , @RequestParam(defaultValue = "1") int pageIndex){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPayload(categoryService.getAllCategories());
        return responseDTO;
    }

    @PostMapping(value = "/categories")
    public ResponseDTO addCategories(@RequestBody List<CategoryDTO> categoryDTOList){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPayload(categoryService.addCategories(categoryDTOList));
        return responseDTO;
    }
}
