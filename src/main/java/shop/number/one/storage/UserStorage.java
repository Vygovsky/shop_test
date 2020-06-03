package shop.number.one.storage;

import shop.number.one.model.User;

import java.util.UUID;

public class UserStorage extends BaseStorage<User, UUID> {

    @Override
    public User save(User user) {
        return super.save(user.getId(), user);
    }
}
