package shop.number.one.services;

import org.springframework.stereotype.Service;
import shop.number.one.model.Order;
import shop.number.one.repositories.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
