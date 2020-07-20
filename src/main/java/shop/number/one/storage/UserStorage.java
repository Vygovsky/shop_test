package shop.number.one.storage;

import shop.number.one.model.User;

import java.util.UUID;

public class UserStorage extends BaseStorage<User, UUID> {

    private static volatile UserStorage INSTANCE;

    private UserStorage() {
    }

    public static UserStorage getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (UserStorage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserStorage();
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public User save(User user) {
        return super.save(user.getId(), user);
    }
}
