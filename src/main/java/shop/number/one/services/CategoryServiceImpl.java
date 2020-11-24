
package shop.number.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long aLong) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
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
        return categoryRepository.getCategoryName(nameCategory);
    }
}

