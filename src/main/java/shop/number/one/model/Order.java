package shop.number.one.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order {
    private long id;
    private User user;
    private Map<Item, Long> items = new HashMap<>();

    public Order(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int amount) {
        items.put(item, items.getOrDefault(item, 0L) + amount);
    }
}
