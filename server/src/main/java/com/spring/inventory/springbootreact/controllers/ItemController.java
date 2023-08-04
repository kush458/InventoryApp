package com.spring.inventory.springbootreact.controllers;

import com.spring.inventory.springbootreact.InventoryRepository;
import com.spring.inventory.springbootreact.models.Item;
import com.spring.inventory.springbootreact.service.ItemService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String id) {

        itemService.deleteItem(id);

        return  new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {

        return new ResponseEntity<Item>(itemService.updateItem(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.GET)
    public  ResponseEntity<List<Item>> getSortedItems(@RequestParam("by") String by) {
        return new ResponseEntity<List<Item>>(itemService.sortItems(by), HttpStatus.OK);
    }

}
