package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.repositories.ItemRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> itemsByCategory(Category category) {
        return itemRepository.itemsByCategory(category);
    }

    public void quantityItemByCategory(long id, int amount) {
        itemRepository.quantityItemByCategory(id, amount);
    }

    public long getCount(long id) {
        return itemRepository.getCount(id);
    }

    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void update(Item item) {
        itemRepository.update(item);
    }

    public void delete(Long id) {
        itemRepository.delete(id);
    }
}
