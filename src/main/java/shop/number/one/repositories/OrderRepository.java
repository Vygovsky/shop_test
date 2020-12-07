package shop.number.one.repositories;

import org.springframework.stereotype.Repository;
import shop.number.one.model.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
}
