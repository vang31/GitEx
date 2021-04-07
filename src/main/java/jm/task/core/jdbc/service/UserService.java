package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.util.List;
/*
    сервисный слой в котором будет работать, сначала клиент к сервису -> service -> dao -> database
*/
public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
