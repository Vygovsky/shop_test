package shop.number.one.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.number.one.model.OrdersItem;

@Repository
public interface OrdersItemRepository extends CrudRepository<OrdersItem, Long> {
}
