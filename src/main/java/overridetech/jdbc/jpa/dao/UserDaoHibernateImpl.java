package overridetech.jdbc.jpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users" +
                "(id serial, " +
                "name character varying(50) NOT NULL, " +
                "lastName character varying(50) NOT NULL, " +
                "age integer NOT NULL)";
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        String sgl = "DROP TABLE IF EXISTS users";
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(sgl).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
