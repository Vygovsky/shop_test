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
import shop.number.one.model.User;
import shop.number.one.services.UserService;

import java.util.Collection;
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
    public Collection<User> getAllUsers()  {
        return userService.findAll();
    }

    @PostMapping(path = "/user/add")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path = "/user/update")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        userService.delete(id);
    }

}
