package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.Order;
import shop.number.one.repositories.OrderRepository;

import java.util.Collection;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Collection<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.update(order);
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }
}
