package shop.number.one.services;

import shop.number.one.model.Category;
import shop.number.one.repositories.CategoryRepository;
import shop.number.one.repositories.CategoryRepositoryImpl;

import java.util.Collection;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository dataBase;

    public CategoryServiceImpl() {
        this.dataBase = new CategoryRepositoryImpl();
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
    public Category save(Category object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
    }

}