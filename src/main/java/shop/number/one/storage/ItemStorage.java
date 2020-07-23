package shop.number.one.storage;

import shop.number.one.model.Category;
import shop.number.one.model.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public enum ItemStorage {
    INSTANCE;

    private final Map<Long, Item> items = new HashMap<>();
    long count;

    ItemStorage() {
        this.save(new Item("Ball", 25, 23, CategoryStorage.INSTANCE.findById(1L)));
        this.save(new Item("MiniBall", 45, 16, CategoryStorage.INSTANCE.findById(1L)));
        this.save(new Item("T-shirt", 90, 3, CategoryStorage.INSTANCE.findById(2L)));
        this.save(new Item("Cup", 44, 12, CategoryStorage.INSTANCE.findById(3L)));
        this.save(new Item("Cross", 25, 35, CategoryStorage.INSTANCE.findById(4L)));
    }

    public Collection<Item> findAll() {
        return items.values();
    }

    public Item findById(Long id) {
        return items.get(id);
    }

    public Item save(Item item) {
        item.setId(++count);
        return items.put(count, item);
    }

    public List<Item> itemsByCategory(Category category) {
        return items.values().stream()
                .filter(item -> item.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public void quantityItemByCategory(long id, int amount) {
        Item itemById = findById(id);
        if (itemById.getAvailableCount() >= amount) {
            itemById.setAvailableCount(itemById.getAvailableCount() - amount);
            items.put(itemById.getId(), itemById);
        }
    }

    public long getCount(long id) {
        Item itemById = findById(id);
        return itemById.getAvailableCount();
    }
}

