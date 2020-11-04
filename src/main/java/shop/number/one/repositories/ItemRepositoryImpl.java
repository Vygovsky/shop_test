
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.model.Item;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private DataSource dataSource;

    @Override
    public List<Item> itemsByCategory(Category category) {
        return null;
    }

    @Override
    public void quantityItemByCategory(long id, int amount) {

    }

    @Override
    public long getCount(long id) {
        return 0;
    }

    @Override
    public Collection<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(Long aLong) {
        return null;
    }

    @Override
    public Item save(Item object) {
        return null;
    }

    @Override
    public Item update(Item object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}

