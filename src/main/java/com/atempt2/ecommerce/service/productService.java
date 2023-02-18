package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.Exceptions.ProductNotExist;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.Category;
import com.atempt2.ecommerce.model.card;
import com.atempt2.ecommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class productService {
@Autowired
productRepository productrep;
    public void createproduct(productDTO productDTO, Category category) {
        Product product=new Product();
        product.setProductName(productDTO.getProductName());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productrep.save(product);
    }
    public productDTO   getProductDTo(Product b){
        productDTO productDTO=new productDTO();
        productDTO.setCategory_id(b.getCategory().getId());
        productDTO.setDescription(b.getDescription());
        productDTO.setProductName(b.getProductName());
        productDTO.setImage(b.getImage());
        productDTO.setPrice(b.getPrice());
        productDTO.setId(b.getId());
        return productDTO;
    }

    public List<productDTO> getAllproducts() {
       List<Product>all=productrep.findAll();
        List<productDTO>productDTOS=new ArrayList<>();
       for (Product product:all){
           productDTOS.add(getProductDTo(product));
       }
       return productDTOS;
    }

    public void updateProduct(productDTO productDTO, Long product_id) throws Exception {
        Optional<Product> product =productrep.findById(product_id);
        if(!product.isPresent()){
            throw new Exception("Procut does not exist");
        }

        Product product1=product.get();

        product1.setDescription(productDTO.getDescription());
        product1.setProductName(productDTO.getProductName());
        product1.setImage(productDTO.getImage());
        product1.setPrice(productDTO.getPrice());

        productrep.save(product1);

    }

    public Product findById(Long prouctId) throws ProductNotExist {
        Optional<Product> product=productrep.findById(prouctId);

        if(!product.isPresent()){
            throw  new ProductNotExist("product not exists"+prouctId);
        }
        return product.get();
    }

    public void deleteProduct(Long productId) {
        Optional<Product> product=productrep.findById(productId);
        if(Objects.isNull(product)){
            throw new ProductNotExist("Product does not exist");
        }
        Product product1=product.get();
        productrep.delete(product1);

    }
}

