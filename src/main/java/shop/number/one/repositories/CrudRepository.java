package shop.number.one.repositories;

public interface CrudRepository<T, ID> {

    T findById(ID id);

    T save(T object);

    void delete(ID id);
}
