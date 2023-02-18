package com.atempt2.ecommerce.controller;

import com.atempt2.ecommerce.common.ApiResponse;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.model.Category;

import com.atempt2.ecommerce.repository.categoryRepository;
import com.atempt2.ecommerce.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
productService productser;
@Autowired
categoryRepository categoryrepo;

@PostMapping("/add")
    public ResponseEntity<ApiResponse> createproduct(@RequestBody productDTO productDTO){
    Optional<Category>category  =categoryrepo.findById(productDTO.getCategory_id());
    if(!category.isPresent()){
        return new ResponseEntity<>(new ApiResponse(false,"Category does not exist"), HttpStatus.BAD_REQUEST);
    }
    productser.createproduct(productDTO,category.get());
    return new ResponseEntity<>(new ApiResponse(true,"Your product has been added"),HttpStatus.CREATED);
}

@GetMapping("/")
    public ResponseEntity<List<productDTO>> getProducts(){
    List<productDTO>productDTOS=productser.getAllproducts();
    return new ResponseEntity<>(productDTOS,HttpStatus.OK);
}

@PostMapping("/update/{product_id}")
    public ResponseEntity<ApiResponse>updateProduct(@PathVariable ("product_id") Long product_id,@RequestBody productDTO productDTO)

    throws Exception{
    Optional<Category>category1=categoryrepo.findById(productDTO.getCategory_id());
        if(!category1.isPresent()){
        return new ResponseEntity<>(new ApiResponse(false,"Category does not exist"), HttpStatus.BAD_REQUEST);
    }
        productser.updateProduct(productDTO,product_id);
        return new ResponseEntity<>(new ApiResponse(true,"Your product has been updte"),HttpStatus.OK);
    }
    @PostMapping("/deleteProduct/{product_id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long product_id){
        productser.deleteProduct(product_id);
        return new ResponseEntity<>(new ApiResponse(true,"Your product has beendeleted"),HttpStatus.OK);
    }


}
