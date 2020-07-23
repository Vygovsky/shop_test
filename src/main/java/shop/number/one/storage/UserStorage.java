package shop.number.one.storage;

import shop.number.one.model.User;
import shop.number.one.repositories.CrudRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum UserStorage {
    INSTANCE;

    private final Map<UUID, User> storage = new HashMap<>();

    public Collection<User> findAll() {
        return storage.values();
    }

    public User save(UUID id, User user) {
        storage.put(id, user);
        return user;
    }

    public User findById(UUID id) {
        return storage.get(id);
    }

    public void delete(UUID id) {
        storage.remove(id);
    }

}
