package com.spring.inventory.springbootreact.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document(collection = "items")
@Data
public class Item {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String imageURL;
    private double price;
    private String description;
    private Date createdAt;

    public Item(String id, String name, String imageURL, double price, String description, Date createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
