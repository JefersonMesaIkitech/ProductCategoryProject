package co.com.jeferson.productsproject.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "products")
public class Product {
    //Product Model

    @Id
    private String id;
    private String name;
    private String description;
    private String categoryName;
    private double price;
    private int stock;
    private float weight;
    private String brand;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
