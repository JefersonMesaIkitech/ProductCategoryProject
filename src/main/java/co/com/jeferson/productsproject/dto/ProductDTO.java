package co.com.jeferson.productsproject.dto;

import lombok.Data;

@Data
public class ProductDTO {
    //The data transfer object for the product

    private String id;
    private String name;
    private String description;
    private String categoryName;
    private double price;
    private int stock;
    private float weight;
    private String brand;
}
