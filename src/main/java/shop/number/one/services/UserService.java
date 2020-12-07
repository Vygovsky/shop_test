package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.User;
import shop.number.one.repositories.UserRepository;

import java.util.Collection;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return user;
    }

    public void delete(UUID uuid) {
        userRepository.delete(uuid);

    }
}
