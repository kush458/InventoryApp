package com.spring.inventory.springbootreact.service;

import com.spring.inventory.springbootreact.InventoryRepository;
import com.spring.inventory.springbootreact.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private InventoryRepository inventoryRepo;

    public List<Item> allItems() {
        return inventoryRepo.findAll();
    }

    public Item createItem(Item item) {
        inventoryRepo.save(item);
        return item;
    }
}
