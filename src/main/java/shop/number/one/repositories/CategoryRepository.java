package shop.number.one.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;

@Component
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    String getCategoryName(String nameCategory);
}
