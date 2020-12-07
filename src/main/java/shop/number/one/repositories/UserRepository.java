package shop.number.one.repositories;

import org.springframework.stereotype.Repository;
import shop.number.one.model.User;

import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
