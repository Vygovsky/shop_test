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
public class DemoSpring implements CommandLineRunner {
    @Autowired
    private CategoryRepositoryImpl repositoryCategory;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category categoryFood = new Category(1L, "Food");
        Category categorySkits = new Category(2L, "Skits");

        Item item = new Item(1L, "sock", 20, categoryFood);
        Item item2 = new Item(2L, "ball", 35, categorySkits);

        User user = new User(1L, "Roman", "ron@ukr.net", new Date());

        Order order = new Order(1L, user);
      //  Order order221 = new Order(1L, user);

        OrdersItem ordersItem = new OrdersItem(1L, item, 20, order);
    //    OrdersItem ordersItem2 = new OrdersItem(2L, item2, 30, order221);

       /* Set<OrdersItem> itemSet = new HashSet<>();
        itemSet.add(ordersItem);
        itemSet.add(ordersItem2);*/


        User save1 = userRepository.save(user);

        Category category = repositoryCategory.save(categoryFood);
        Category category1 = repositoryCategory.save(categorySkits);

        Item item11 = itemRepository.save(item);
        Item item22 = itemRepository.save(item2);

        Order order1 = orderRepository.save(order);
        //    Order order2= orderRepository.save(order221);

        OrdersItem ordersItem1 = ordersItemRepository.save(ordersItem);
       // OrdersItem ordersItem3 = ordersItemRepository.save(ordersItem2);


    }
}
