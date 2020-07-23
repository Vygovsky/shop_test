package shop.number.one.repositories;

import shop.number.one.model.User;
import shop.number.one.storage.UserStorage;

import java.util.Collection;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Collection<User> findAll() {
        return UserStorage.INSTANCE.findAll();
    }

    @Override
    public User findById(UUID id) {
        return UserStorage.INSTANCE.findById(id);
    }

    @Override
    public User save(User user) {
        return UserStorage.INSTANCE.save(UUID.randomUUID(), user);
    }

    @Override
    public void delete(UUID id) {
        UserStorage.INSTANCE.delete(id);
    }
}
