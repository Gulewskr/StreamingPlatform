package rg.ragulajw.services;

import rg.ragulajw.data.domain.User;

import java.util.List;

public interface IUserServices {
    User add(User user);
    User getById(long id);
    List<User> getAll();
    User update(User user, long id);
    void deleteById(long id);

    User getByLoginAndPassword(String login, String password);
}
