package shop.number.one.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
@Table (name = "ORDERS")
public class Order {
    private UUID id;
    @OneToOne
    @JoinColumn(name = "CATEGORY_ID", unique = true, nullable = false)
    private User user;
    @ManyToOne
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

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        return this$id == null ? other$id == null : this$id.equals(other$id);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + this.getId() +
                ", user=" + this.getUser() +
                ", items=" + this.getItems() +
                '}';
    }
}
