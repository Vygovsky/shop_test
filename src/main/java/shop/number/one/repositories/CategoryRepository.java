package shop.number.one.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    String getCategoryName(String nameCategory);
}
