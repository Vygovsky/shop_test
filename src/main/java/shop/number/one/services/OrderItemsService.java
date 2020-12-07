package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.OrdersItem;
import shop.number.one.repositories.OrdersItemRepository;

import java.util.Collection;


@Service
public class OrderItemsService {

    private final OrdersItemRepository ordersItemRepository;


    public OrderItemsService(OrdersItemRepository ordersItemRepository) {
        this.ordersItemRepository = ordersItemRepository;
    }

    public Collection<OrdersItem> findAll() {
        return ordersItemRepository.findAll();
    }


    public OrdersItem findById(Long id) {
        return ordersItemRepository.findById(id);
    }


    public OrdersItem save(OrdersItem ordersItem) {
        return ordersItemRepository.save(ordersItem);
    }

    public OrdersItem update(OrdersItem ordersItem) {
        return ordersItemRepository.update(ordersItem);
    }


    public void delete(Long id) {
        ordersItemRepository.delete(id);
    }
}
