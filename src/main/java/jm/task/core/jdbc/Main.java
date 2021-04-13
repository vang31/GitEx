package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.HibernateUtil;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        Util util = new Util();
//        util.connectToDB();

//        UserDaoJDBCImpl userDJBDC = new UserDaoJDBCImpl();
        //userDJBDC.createUsersTable();
        //userDJBDC.removeUserById(1);
        //userDJBDC.cleanUsersTable();
        //userDJBDC.saveUser("ted","Nguyen", (byte) 22);
//        userDJBDC.dropUsersTable();
        //System.out.println(userDJBDC.getAllUsers());

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        // Check database version
//        String sql = "SELECT version()";
//
//        String result = (String) session.createNativeQuery(sql).getSingleResult();
//            System.out.println("PostgreSQL version is :::");
//        System.out.println(result);
//
//        session.getTransaction().commit();
//        session.close();
//
//        HibernateUtil.shutdown();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        //userDaoHibernate.dropUsersTable();
//      userDaoHibernate.saveUser("Dorroty", "Nguyen", (byte)22);
 //       userDaoHibernate.removeUserById(5);
        // System.out.println(userDaoHibernate.getAllUsers());
//       userDaoHibernate.cleanUsersTable();

    }
}
