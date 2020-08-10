package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;

import java.util.Collection;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRepositoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id);
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
        return categoryRepository.getCategoryName(id);
    }
}
