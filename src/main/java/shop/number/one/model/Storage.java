package shop.number.one.model;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Category, Map<Item, Integer>> categoryItems = new HashMap<Category, Map<Item, Integer>>(){{
        put(Category.INVENTORY, new HashMap<Item, Integer>(){{
            put(new Item(1L, "Ball", 25), 0);
            put(new Item(2L, "MiniBall", 45), 10);
        }});
        put(Category.CLOTHES, new HashMap<Item, Integer>(){{
            put(new Item(3L, "T-shirt", 105), 10);
        }});
        put(Category.CAP, new HashMap<Item, Integer>(){{
            put(new Item(4L, "Cup", 98), 10);
        }});
        put(Category.FOOTWEAR, new HashMap<Item, Integer>(){{
            put(new Item(5L, "Cross", 2150), 10);
        }});
    }};

    public Map<Item, Integer> itemsByCategory(Category category) {
        return categoryItems.get(category);
    }

    public Item getItemByIdFromCategory(Category category, long id) {
        Map<Item, Integer> items = categoryItems.get(category);
        return items.keySet().stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .get();

    }

    public void addItemToCategory(Category category, Item item) {
        Map<Item, Integer> items = categoryItems.getOrDefault(category, new HashMap<>());
        items.put(item, items.getOrDefault(item, 0) + 1);
        categoryItems.put(category, items);
    }
}
