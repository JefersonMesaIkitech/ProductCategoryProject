package co.com.jeferson.productsproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDTO {
    //The data transfer object for the category

    private String id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
