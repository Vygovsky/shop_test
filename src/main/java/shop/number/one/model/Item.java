package shop.number.one.model;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {
    private Long id;
    private String name;
    private int price;
    private long availableCount;
    private Category category;

    public Item( String name, int price, long availableCount, Category category) {
        this.name = name;
        this.price = price;
        this.availableCount = availableCount;
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
                ", availableCount=" + this.getAvailableCount() +
                ", category=" + this.getCategory() +
                '}';
    }
}
