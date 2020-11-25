
package shop.number.one.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.repositories.ItemRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Override
    public List<Item> itemsByCategory(Category category) {
        return null;
    }

    @Override
    public void quantityItemByCategory(long id, int amount) {

    }

    @Transactional
    @Override
    public long getCount(long id) {
        return 0;
    }

    @Transactional
    @Override
    public Collection<Item> findAll() {
        return null;
    }

    @Transactional
    @Override
    public Item findById(Long aLong) {
        return null;
    }

    @Transactional
    @Override
    public Item save(Item object) {
        return null;
    }

    @Transactional
    @Override
    public Item update(Item object) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Long aLong) {

    }
}

