package com.atempt2.ecommerce.controller;


import com.atempt2.ecommerce.common.ApiResponse;
import com.atempt2.ecommerce.model.Category;


import com.atempt2.ecommerce.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {
@Autowired
private categoryService categoryservice;
@PostMapping("/create")
@CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<ApiResponse>  createcategory(@RequestBody Category category){
    categoryservice.createCategory(category);
    return new ResponseEntity<>(new ApiResponse(true,"You created new category"),HttpStatus.CREATED);
    }
    @PostMapping("/categories")
    public List<Category> listCategory(){
    return categoryservice.listCategory();
    }

    @PostMapping("/update/{category_id}")
    public ResponseEntity<ApiResponse> updaateCategory(@PathVariable("category_id")Long category_id,@RequestBody Category category){

       if(!categoryservice.findById(category_id)){
           return  new ResponseEntity<>(new ApiResponse(false,"id does not exist"),HttpStatus.NOT_FOUND);
       }
        categoryservice.editCategory(category_id,category);
        return  new ResponseEntity<>(new ApiResponse(true,"Categroy has been updated"),HttpStatus.OK);

    }


}
