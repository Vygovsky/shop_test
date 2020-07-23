package shop.number.one.repositories;

import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.storage.ItemStorage;

import java.util.Collection;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {

    private ItemStorage dataBaseItems;

    public ItemRepositoryImpl() {
        this.dataBaseItems = ItemStorage.INSTANCE;
    }

    @Override
    public Collection<Item> findAll() {
        return dataBaseItems.findAll();
    }

    @Override
    public Item findById(Long id) {
        return dataBaseItems.findById(id);
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
        return dataBaseItems.itemsByCategory(category);
    }

    @Override
    public void quantityItemByCategory(long id, int amount) {
        dataBaseItems.quantityItemByCategory(id, amount);
    }

    @Override
    public long getCount(long id) {
        return dataBaseItems.getCount(id);
    }

}
