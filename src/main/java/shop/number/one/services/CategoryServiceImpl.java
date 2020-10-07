package shop.number.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepositoryImpl;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepositoryImpl categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepositoryImpl categoryRepository) {
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
    public Category save(Category object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
    }

}
