package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void updateUserByID(int id, User user);
    void deleteUserById(int id);
    User getUserById(int id);
    List<User> getAllUsers();
}
