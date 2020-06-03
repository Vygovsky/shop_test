package shop.number.one.repositories;

import shop.number.one.model.User;
import shop.number.one.storage.UserStorage;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    private final UserStorage userStorage;

    public UserRepositoryImpl() {
        this.userStorage = new UserStorage();
    }

    @Override
    public User findById(UUID id) {
        return userStorage.findById(id);
    }

    @Override
    public User save(User user) {
        return userStorage.save(user);
    }

    @Override
    public void delete(UUID id) {
        userStorage.delete(id);
    }
}
