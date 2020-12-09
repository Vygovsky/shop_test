package shop.number.one.controller;

import org.springframework.web.bind.annotation.*;
import shop.number.one.model.User;
import shop.number.one.services.UserService;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping(path = "/users", produces = "application/json")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path = "/user/add")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping(path = "/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        userService.delete(id);
    }

}
