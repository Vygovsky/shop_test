package shop.number.one.controller;

import org.springframework.web.bind.annotation.*;
import shop.number.one.model.Item;
import shop.number.one.services.ItemService;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseBody
    @GetMapping(path = "/items", produces = "application/json")
    public Iterable<Item> getAllUsers() {
        return itemService.findAll();
    }

    @PostMapping(path = "/item/add")
    public void createUser(@RequestBody Item item) {
        itemService.save(item);
    }

    @GetMapping(path = "/item/{id}")
    public Optional<Item> getUserById(@PathVariable("id") long id) {
        return itemService.findById(id);
    }

    @DeleteMapping("/item/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        itemService.delete(id);
    }

}
