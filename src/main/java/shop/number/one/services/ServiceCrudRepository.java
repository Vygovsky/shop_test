package shop.number.one.services;

import java.util.Collection;

public interface ServiceCrudRepository<T, ID> {

    Collection<T> findAll();

    T findById(ID id);

    T save(T object);

    T update(T object);

    void delete(ID id);
}
