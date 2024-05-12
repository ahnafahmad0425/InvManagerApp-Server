package com.example.invmanager.service;

import com.example.invmanager.model.Item;
import java.util.*;
public interface IItemService {

    Item addItem(Item item);

    List<Item> getItems();

    Item updateItem(Item item, Long id);

    Item getItemById(Long id);

    void deleteItem(Long id);

}
