package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private Connection connection;

    public Connection connectToDB(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/task1",
                    "postgres",
                    "tungking01");
            System.out.println("success");

            return connection;

        } catch (SQLException e) {
            System.out.println("Download Driver failed");
        }
        return connection;
    }
}
