package shop.number.one.services;

import shop.number.one.model.Category;
import shop.number.one.model.Item;

import java.util.List;

public interface ItemService extends CrudService<Item, Long> {

    List<Item> itemsByCategory(Category category);

    void quantityItemByCategory(long id, int amount);

    long getCount(long id);

}
