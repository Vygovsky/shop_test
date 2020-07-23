package shop.number.one.storage;


import shop.number.one.model.Category;

import javax.naming.NameNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum CategoryStorage {
    INSTANCE;

    private Map<Long, Category> categories = new HashMap<>();

    CategoryStorage() {
        categories.put(1L, new Category(1L, "INVENTORY"));
        categories.put(2L, new Category(2L, "CLOTHES"));
        categories.put(3L, new Category(3L, "CAP"));
        categories.put(4L, new Category(4L, "FOOTWEAR"));
    }

    public Collection<Category> findAll() {
        return categories.values();
    }

    public Category findById(Long id) {
        return categories.get(id);
    }

    public String getCategoryName(long numberCategory) {
        return categories.values()
                .stream()
                .filter(category -> category.getId() == numberCategory)
                .map(Category::getName)
                .findFirst().orElse("empty");
    }

    public Category getByNameCategory(String numberCategory) throws NameNotFoundException {
        return categories.values()
                .stream()
                .filter(category -> category.getName().equalsIgnoreCase(numberCategory))
                .findFirst().orElseThrow(NameNotFoundException::new);
    }
}