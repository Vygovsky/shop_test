package shop.number.one.repositories;

import shop.number.one.model.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    String getCategoryName(long id);
}
