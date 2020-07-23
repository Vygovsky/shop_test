package shop.number.one.services;

import shop.number.one.model.User;
import shop.number.one.repositories.UserRepository;
import shop.number.one.repositories.UserRepositoryImpl;
import shop.number.one.storage.UserStorage;

import java.util.Collection;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserStorage userStorage;

    public UserServiceImpl() {
        this.userStorage = UserStorage.INSTANCE;
    }

    @Override
    public Collection<User> findAll() {
        return userStorage.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userStorage.findById(id);
    }


    @Override
    public User save(User user) {
        return userStorage.save(UUID.randomUUID(), user);
    }

    @Override
    public void delete(UUID id) {
        userStorage.delete(id);
    }
}
