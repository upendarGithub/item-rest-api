package com.example.itemapi.controller;

import com.example.itemapi.model.Item;
import com.example.itemapi.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 🔹 TEST ENDPOINT (IMPORTANT)
    @GetMapping("/test")
    public String test() {
        return "API WORKING";
    }

    // 🔹 ADD ITEM
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        if (item.getId() == null || item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Item ID and Name are required");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemService.addItem(item));
    }

    // GET all items
    @GetMapping
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }


    // 🔹 GET ITEM BY ID
    @GetMapping("/{id}")
public ResponseEntity<?> getItemById(@PathVariable long id) {

    var optionalItem = itemService.getItemById(id);

    if (optionalItem.isPresent()) {
        return ResponseEntity.ok(optionalItem.get());
    } else {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }
}
}
