package com.spring.inventory.springbootreact.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "items")
@Data
public class Item {

    @Id
    private ObjectId id;

    private String name;
    private String imageURL;
    private double price;
    private String description;
    private Date createdAt;

    public Item(ObjectId id, String name, String imageURL, double price, String description, Date createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
    }

}
