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
import shop.number.one.model.Item;
import shop.number.one.repositories.ItemRepository;
import shop.number.one.services.ItemService;

import java.util.Collection;


@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseBody
    @GetMapping(path = "/items", produces = "application/json")
    public Collection<Item> getAllUsers() {
        return itemService.findAll();
    }

    @PostMapping(path = "/item/add")
    public void createUser(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping(path = "/item/update")
    public void updateUser(@RequestBody Item item) {
        itemService.update(item);
    }

    @GetMapping(path = "/item/{id}")
    public Item getUserById(@PathVariable("id") long id) {
        return itemService.findById(id);
    }

    @DeleteMapping("/item/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        itemService.delete(id);
    }

}
