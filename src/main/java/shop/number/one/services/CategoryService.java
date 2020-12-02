package shop.number.one.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepository;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public String getCategoryName(String nameCategory) {
        return categoryRepository.getCategoryName(nameCategory);
    }

    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }


    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }


    public Category update(Category category) {
        return categoryRepository.update(category);
    }


    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
