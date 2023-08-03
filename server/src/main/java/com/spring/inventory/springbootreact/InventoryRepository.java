package com.spring.inventory.springbootreact;

import com.spring.inventory.springbootreact.models.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Item, ObjectId> {
}
