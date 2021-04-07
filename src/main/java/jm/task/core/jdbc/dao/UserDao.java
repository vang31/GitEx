package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;
//это data acsess object - функционал проги, то что должна уметь выполнять
//это некая прослойки клиент не работал на прямую с хранилищем данных
public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
