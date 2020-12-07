package shop.number.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import shop.number.one.model.*;
import shop.number.one.repositories.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@SpringBootApplication
public class DemoSpring/* implements CommandLineRunner*/ {
    /*@Autowired
    private CategoryRepository repositoryCategory;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    @Autowired
    private OrderRepository orderRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(DemoSpring.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {
        Category categoryFood = new Category(1L, "Food");
        Category categorySkits = new Category(2L, "Skits");
        repositoryCategory.save(categoryFood);
        repositoryCategory.save(categorySkits);


        Item item = new Item(1L, "sock", 20, categoryFood);
        Item item2 = new Item(2L, "ball", 35, categorySkits);
        Item item3 = new Item(3L, "miniBall", 35, categorySkits);
        itemRepository.save(item);
        itemRepository.save(item2);
        itemRepository.save(item3);*/

       /* User user = new User(1L, "Roman", "ron@ukr.net", new Date());
        userRepository.save(user);

        Order order = new Order(1L, user);
        orderRepository.save(order);

        OrdersItem ordersItem = new OrdersItem(1L, item, 20, order);
        OrdersItem ordersItem2 = new OrdersItem(2L, item2, 30, order);
        OrdersItem ordersItem3 = new OrdersItem(3L, item3, 45, order);
        ordersItemRepository.save(ordersItem);
        ordersItemRepository.save(ordersItem2);
        ordersItemRepository.save(ordersItem3);*/
        //itemRepository.findAll().forEach(System.out::println);
    //}

}
