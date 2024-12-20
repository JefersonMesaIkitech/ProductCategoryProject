package co.com.jeferson.productsproject.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "categories")
public class Category {
    //Category model

    @Id
    private String id;
    private String name;
    private String description;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

}
