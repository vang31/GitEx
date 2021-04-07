package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        Util util = new Util();
//        util.connectToDB();

        UserDaoJDBCImpl userDJBDC = new UserDaoJDBCImpl();
        //userDJBDC.createUsersTable();
        //userDJBDC.removeUserById(1);
        //userDJBDC.cleanUsersTable();
        //userDJBDC.saveUser("Tom","Holland", (byte) 22);
        //userDJBDC.dropUsersTable();
    }
}
