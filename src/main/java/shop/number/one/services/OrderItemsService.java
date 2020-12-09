package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.OrdersItem;
import shop.number.one.repositories.OrdersItemRepository;

import java.util.Optional;

@Service
public class OrderItemsService {

    private final OrdersItemRepository ordersItemRepository;

    public OrderItemsService(OrdersItemRepository ordersItemRepository) {
        this.ordersItemRepository = ordersItemRepository;
    }

    public Iterable<OrdersItem> findAll() {
        return ordersItemRepository.findAll();
    }

    public Optional<OrdersItem> findById(Long id) {
        return ordersItemRepository.findById(id);
    }

    public OrdersItem save(OrdersItem ordersItem) {
        return ordersItemRepository.save(ordersItem);
    }


    public void delete(Long id) {
        ordersItemRepository.deleteById(id);
    }
}
