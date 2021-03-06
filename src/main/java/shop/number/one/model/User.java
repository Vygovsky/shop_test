package shop.number.one.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private UUID id;
    private Long id;
    private String nickname;
    private String email;
    private Date birthday;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

 /*   public User(String nickname, String email, Date birthday, Set<Order> orders) {
        this(UUID.randomUUID(), nickname, email, birthday, orders);
    }*/

    public User(Long id, String nickname, String email, Date birthday) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
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