package shop.number.one.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Category {
    CLOTHES(1),
    INVENTORY(2),
    FOOTWEAR(3),
    CAP(4);

    @Getter
    private int id;
}
