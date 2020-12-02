package shop.number.one.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.model.User;
import shop.number.one.repositories.ItemRepository;
import shop.number.one.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    public Collection<User> findAll() {
        return null;
    }

    public User findById(UUID uuid) {
        return null;
    }

    public User save(User object) {
        return null;
    }

    public User update(User object) {
        return null;
    }

    public void delete(UUID uuid) {

    }
}
