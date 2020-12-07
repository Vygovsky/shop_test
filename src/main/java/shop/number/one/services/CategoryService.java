package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepository;

import java.util.Optional;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public String getCategoryName(String nameCategory) {
        return categoryRepository.getCategoryName(nameCategory);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }


    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
