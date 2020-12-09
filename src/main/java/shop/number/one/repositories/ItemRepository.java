package shop.number.one.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.model.Item;

import java.util.List;
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

/*    List<Item> itemsByCategory(Category category);

    void quantityItemByCategory(long id, int amount);

    long getCount(long id);*/
}
