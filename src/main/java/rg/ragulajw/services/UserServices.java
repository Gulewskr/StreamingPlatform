package rg.ragulajw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rg.ragulajw.data.domain.User;
import rg.ragulajw.repositories.UserRepository;

import java.util.List;

@Service
public class UserServices implements IUserServices{
    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user, long id) {
        return userRepository.findById(id)
                .map(oldUser -> {
                    oldUser.setName(user.getName());
                    oldUser.setEmail(user.getEmail());
                    oldUser.setPassword(user.getPassword());
                    return userRepository.save(oldUser);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByLoginAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
