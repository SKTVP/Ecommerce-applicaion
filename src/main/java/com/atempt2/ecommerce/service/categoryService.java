package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.model.Category;

import com.atempt2.ecommerce.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    @Autowired
    private categoryRepository categoryRepo;
    public void createCategory(Category b){
      categoryRepo.save(b);
    }
    public List<Category> listCategory(){
        return categoryRepo.findAll();}

    public void editCategory(Long category_id,Category updcategory){
        Category category1 =categoryRepo.getReferenceById(category_id);
        category1.setCategoryName(updcategory.getCategoryName());
        category1.setDescription(updcategory.getDescription());
        category1.setImage(updcategory.getImage());
        categoryRepo.save(category1);

    }

    public boolean findById(Long categoryId) {
        return categoryRepo.findById(categoryId).isPresent();

    }
}
