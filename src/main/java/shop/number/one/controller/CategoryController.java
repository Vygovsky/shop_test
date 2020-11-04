package shop.number.one.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.number.one.model.Category;
import shop.number.one.model.User;
import shop.number.one.services.CategoryService;
import shop.number.one.services.UserService;

import java.util.Collection;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping(path = "/categories", produces = "application/json")
    public Collection<Category> getAllUsers() {
        return categoryService.findAll();
    }

    @GetMapping(path = "/category/{name}")
    public String getUserById(@PathVariable("name") String name) {
        return categoryService.getCategoryName(name);
    }


    @PostMapping(path = "/category/add")
    public void createUser(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping(path = "/category/update")
    public void updateUser(@RequestBody Category category) {
        categoryService.update(category);
    }

    @GetMapping(path = "/category/{id}")
    public Category getUserById(@PathVariable("id") long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/category/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        categoryService.delete(id);
    }

}
