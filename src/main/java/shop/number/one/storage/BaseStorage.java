package shop.number.one.storage;

import shop.number.one.repositories.CrudRepository;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseStorage<T, ID> implements CrudRepository<T, ID> {

    private Map<ID, T> storage = new HashMap<>();

    @Override
    public T findById(ID id) {
        return storage.get(id);
    }

    public T save(ID id, T t) {
        storage.put(id, t);
        return t;
    }

    @Override
    public void delete(ID id) {
        storage.remove(id);
    }
}
