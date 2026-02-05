package com.example.itemapi.service;

import com.example.itemapi.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }
    public Optional<Item> getItemById(long id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }
    

public List<Item> getAllItems() {
    return items;
}
}