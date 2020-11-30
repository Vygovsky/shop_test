package shop.number.one.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Item item;
    private int count;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", unique = true, nullable = false)
    private Order order;

    public OrdersItem(Long id, Item item, int count) {
        this.id = id;
        this.item = item;
        this.count = count;
    }

  /*  public OrdersItem(Long id, Item item, int count, Order order) {
        this.id = id;
        this.item = item;
        this.count = count;
        this.order = order;
    }*/

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
        return "OrdersItem{" +
                "id=" + this.getId() +
                ", count=" + this.getCount() +
                ", item=" + this.getItem() +
                //     ", order=" + this.getOrder() +
                '}';
    }
}
