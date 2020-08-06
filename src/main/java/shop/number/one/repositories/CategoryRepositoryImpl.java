package shop.number.one.repositories;

import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.storage.CategoryStorage;

import java.util.Collection;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private CategoryStorage dataBase;


    public CategoryRepositoryImpl() {
        this.dataBase = CategoryStorage.INSTANCE;
    }

    @Override
    public Collection<Category> findAll() {
        return dataBase.findAll();
    }

    @Override
    public Category findById(Long id) {
        return dataBase.findById(id);
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete by id don`t work");
    }

    @Override
    public String getCategoryName(long id) {
        return dataBase.getCategoryName(id);
    }
}
