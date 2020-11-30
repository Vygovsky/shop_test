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
@SequenceGenerator(name = "SECQNAMEINENTITY", sequenceName = "DB_SECQ NAME", allocationSize = 1)
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", unique = true, nullable = false)
    private Category category;

    @OneToOne(mappedBy = "item",
            fetch = FetchType.LAZY, optional = false,
            cascade = CascadeType.ALL)
    private OrdersItem ordersItem;

    public Item(Long id, String name, int price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Item(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Item)) return false;
        final Item other = (Item) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        return this$id == null ? other$id == null : this$id.equals(other$id);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Item;
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
        return "Item{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", category=" + this.getCategory() +
                '}';
    }
}