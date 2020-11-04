
package shop.number.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryService;

    @Autowired
    public void setCategoryService(CategoryRepository repository) {
        this.categoryService = repository;
    }

    @Override
    public Collection<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public Category findById(Long aLong) {
        return null;
    }

    @Override
    public Category save(Category object) {
        return null;
    }

    @Override
    public Category update(Category object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public String getCategoryName(String nameCategory) {
        return categoryService.getCategoryName(nameCategory);
    }
}

