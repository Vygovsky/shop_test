package shop.number.one.controller;

import org.springframework.web.bind.annotation.*;
import shop.number.one.model.Category;
import shop.number.one.services.CategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping(path = "/categories", produces = "application/json")
    public Iterable<Category> getAllUsers() {
        return categoryService.findAll();
    }

    @GetMapping(path = "/category/{name}")
    public String getCategoryName(@PathVariable("name") String name) {
        return categoryService.getCategoryName(name);
    }

    @PostMapping(path = "/category/add")
    public void createUser(@RequestBody Category category) {
        categoryService.save(category);
    }


    @GetMapping(path = "/category/{id}")
    public Optional<Category> getUserById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/category/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }

}
