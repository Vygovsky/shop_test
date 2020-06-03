package shop.number.one.services;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T object);

    void delete(ID id);
}
