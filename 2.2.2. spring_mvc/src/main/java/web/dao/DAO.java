package web.dao;

import web.model.User;

import java.util.List;

public interface DAO {
    void createUsersTable();

    void dropUsersTable();

    void cleanUsersTable();

    void saveUser(User user);

    void updateUser(int id,User updateUser);

    void removeUserById(int id);

    List<User> getAllUsers();


}
