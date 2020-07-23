package shop.number.one.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Item {
    private long id;
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
}
