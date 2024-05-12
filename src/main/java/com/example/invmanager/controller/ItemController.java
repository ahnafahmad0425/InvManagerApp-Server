package com.example.invmanager.controller;

import java.util.*;
import com.example.invmanager.service.IItemService;
import lombok.RequiredArgsConstructor;
import com.example.invmanager.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/Items")
@RequiredArgsConstructor
public class ItemController {

    private final IItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getItems(){
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.FOUND);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable Long id){
        return itemService.updateItem(item, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }


}
