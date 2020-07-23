package shop.number.one.model;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {
    private UUID id;
    private String nickname;
    private String email;
    private Date birthday;

    public User(String nickname, String email, Date birthday) {
        this(UUID.randomUUID(), nickname, email, birthday);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        return this$id == null ? other$id == null : this$id.equals(other$id);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
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
        return "User{" +
                "id=" + this.getId() +
                ", nickname='" + this.getNickname() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", birthday=" + this.getBirthday() +
                '}';
    }
}
