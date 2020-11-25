
package shop.number.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Category update(Category category) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        System.out.println("Your don`t delete category");
    }

    @Transactional
    @Override
    public String getCategoryName(String nameCategory) {
        return categoryRepository.getCategoryName(nameCategory);
    }
}

