package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.User;
import shop.number.one.repositories.UserRepository;
import shop.number.one.repositories.UserRepositoryImpl;

import java.util.Collection;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id);
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
