package shop.number.one.services;


import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.repositories.ItemRepository;
import shop.number.one.repositories.ItemRepositoryImpl;

import java.util.Collection;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl() {
        this.itemRepository = new ItemRepositoryImpl();
    }

    @Override
    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
    }

    @Override
    public List<Item> itemsByCategory(Category category) {
        return itemRepository.itemsByCategory(category);
    }

    @Override
    public void quantityItemByCategory(long id, int amount) {
        itemRepository.quantityItemByCategory(id, amount);
    }

    @Override
    public long getCount(long id) {
        return itemRepository.getCount(id);
    }

}