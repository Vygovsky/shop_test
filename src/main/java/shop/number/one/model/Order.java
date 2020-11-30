package shop.number.one.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<OrdersItem> ordersItems;

    public Order(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Order(Long id, User user, Set<OrdersItem> ordersItems) {
        this.id = id;
        this.user = user;
        this.ordersItems = ordersItems;
    }

    public void addItem(OrdersItem ordersItem) {
        ordersItems.add(ordersItem);
        ordersItem.setOrder(this);
    }

    public void removeItem(OrdersItem ordersItem) {
        ordersItems.remove(ordersItem);
        ordersItem.setOrder(null);
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
                ", items=" + this.getOrdersItems() +
                '}';
    }
}
