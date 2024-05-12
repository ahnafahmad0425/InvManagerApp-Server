package com.example.invmanager.service;

import com.example.invmanager.exception.ItemNotFoundException;
import com.example.invmanager.model.Item;
import com.example.invmanager.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {
    private final ItemRepository itemRepository;
    @Override
    public Item addItem(Item item) {

        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Item item, Long id) {
        return itemRepository.findById(id).map( item1 -> {
            item1.setName(item.getName());
            item1.setStatus(item.getStatus());
            item1.setPurchaseDate(item.getPurchaseDate());
            item1.setPrice(item.getPrice());
            item1.setSoldPrice(item.getSoldPrice());
            item1.setProfit(item.getProfit());
            item1.setSaleDate(item.getSaleDate());
            return itemRepository.save(item1);
        }).orElseThrow(() -> new ItemNotFoundException("Item could not be found."));
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item could not be found."));
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)){
            throw new ItemNotFoundException("Item could not be found.");
        }
        itemRepository.deleteById(id);
    }
}
