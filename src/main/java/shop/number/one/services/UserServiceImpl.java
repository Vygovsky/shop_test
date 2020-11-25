package shop.number.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.number.one.model.User;
import shop.number.one.repositories.UserRepository;

import java.util.Collection;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository repository) {
        this.userRepository = repository;
    }

    @Transactional
    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User findById(UUID id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
