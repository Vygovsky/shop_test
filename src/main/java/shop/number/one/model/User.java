package shop.number.one.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private UUID id;
    private String nickname;
    private String email;
    private Date birthday;

    public User(String nickname, String email, Date birthday) {
        this(UUID.randomUUID(), nickname, email, birthday);
    }
}
