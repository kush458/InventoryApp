package com.spring.inventory.springbootreact.controllers;

import com.spring.inventory.springbootreact.InventoryRepository;
import com.spring.inventory.springbootreact.models.Item;
import com.spring.inventory.springbootreact.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<List<Item>>(itemService.allItems(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Item> addItem(@RequestBody Item newItem) {
        newItem.setCreatedAt(new Date());
        return new ResponseEntity<Item>(itemService.createItem(newItem), HttpStatus.CREATED);
    }

}
