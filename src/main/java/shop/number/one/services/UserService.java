package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.User;
import shop.number.one.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);

    }
}
