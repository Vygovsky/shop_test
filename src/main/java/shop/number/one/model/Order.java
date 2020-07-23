package shop.number.one.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order {
    private UUID id;
    private User user;
    private Map<Item, Long> items = new HashMap<>();

    public Order(User user) {
        this.id = UUID.randomUUID();
        this.user = user;
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, long amount) {
        items.put(item, items.getOrDefault(item, 0L) + amount);
    }
}
