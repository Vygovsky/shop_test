package shop.number.one.repositories;

import java.util.Collection;

public interface CrudRepository<T, ID> {

    Collection<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(ID id);
}
