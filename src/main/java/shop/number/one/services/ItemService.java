package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

  /*  public List<Item> itemsByCategory(Category category) {
        return itemRepository.itemsByCategory(category);
    }

    public void quantityItemByCategory(long id, int amount) {
        itemRepository.quantityItemByCategory(id, amount);
    }

    public long getCount(long id) {
        return itemRepository.getCount(id);
    }*/

    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
