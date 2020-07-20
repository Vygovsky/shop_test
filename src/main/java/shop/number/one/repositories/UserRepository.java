package shop.number.one.repositories;

import shop.number.one.model.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
