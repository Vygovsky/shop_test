package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.model.Item;

import java.util.Collection;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemRepositoryImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
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
