package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
//конфигурация хиберната
public class UserDaoHibernateImpl implements UserDao {

    private Transaction transaction = null;
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String queryText = "CREATE TABLE IF NOT EXISTS Users(id serial,  " +
                "firstname VARCHAR(30) not null, lastName VARCHAR(30) not null, age int not null);";

        try{
            transaction = session.beginTransaction();

            //Создаем SQL запрос
            session.createSQLQuery(queryText).executeUpdate();

            //Если запросы выполнились, то подтверждаем
            session.getTransaction().commit();
            System.out.println("Creating table by Hibernate ---success");

        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        String queryText = "DROP TABLE Users;";

        try{
            transaction = session.beginTransaction();

            //Создаем SQL запрос
            session.createSQLQuery(queryText).executeUpdate();

            //Если запросы выполнились, то подтверждаем
            session.getTransaction().commit();
            System.out.println("Droping table by Hibernate ---success");

        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String queryText = "INSERT INTO Users(firstname, lastName, age) VALUES (" + "'" + name  + "'"
                + "," + "'" + lastName + "'" + ","+ age + ");";

        try{
            session.beginTransaction();
            session.createSQLQuery(queryText).executeUpdate();
            session.getTransaction().commit();
        } catch(Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();}
    }

    @Override
    public void removeUserById(long id) {
        String queryText = "DELETE FROM Users " +
                "WHERE id =" + id;
        try{
            session.beginTransaction();
            session.createSQLQuery(queryText).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Removing user by id =" + id + " success");
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try{
            session.beginTransaction();
            Query query = session.createNativeQuery("FROM Users", User.class);
            list = query.list();
            session.getTransaction().commit();

        } catch(Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public void cleanUsersTable() {
        String queryText = "DELETE FROM Users;";
        try{
            session.beginTransaction();
            session.createSQLQuery(queryText).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Cleaning the table - complete");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
