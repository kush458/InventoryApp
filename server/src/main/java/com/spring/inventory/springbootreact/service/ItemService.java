package com.spring.inventory.springbootreact.service;

import com.spring.inventory.springbootreact.InventoryRepository;
import com.spring.inventory.springbootreact.models.Item;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private InventoryRepository inventoryRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Item> allItems() {
        return inventoryRepo.findAll();
    }

    public Item createItem(Item item) {
        inventoryRepo.save(item);
        return item;
    }

    public void deleteItem(String id) {
        inventoryRepo.deleteById(id);
    }

    public Item updateItem(Item item) {
        /*
          save() method does not accept any parameters or criteria to find the document that has to be updated.
          It by default tries to find the document using ‘_id’ if provided with the document object.
        */
        return inventoryRepo.save(item);
    }

    public List<Item> sortItems(String by) {
        return inventoryRepo.findAll(Sort.by(Sort.Direction.ASC, by));
    }
}
