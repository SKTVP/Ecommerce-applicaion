package com.atempt2.ecommerce.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "category_id")
        private @NotNull Long id;

        private String categoryName;

        private String description;

        private String image;


        //Getters & Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}




