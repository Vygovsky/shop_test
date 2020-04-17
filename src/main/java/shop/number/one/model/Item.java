package shop.number.one.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Item {
    private long id;
    private String name;
    private int price;
}