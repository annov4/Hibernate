package overridetech.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import overridetech.jdbc.jpa.model.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "3772";
    private static Connection connection;
    private static SessionFactory sessionFactory;

    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();

                configuration.setProperty(Environment.URL, URL);
                configuration.setProperty(Environment.USER, USERNAME);
                configuration.setProperty(Environment.PASS, PASSWORD);
                configuration.setProperty(Environment.DRIVER,DRIVER);
                configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty(Environment.SHOW_SQL, "true");
                configuration.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperty(Environment.HBM2DDL_AUTO, "");

                configuration.addAnnotatedClass(User.class);//в какой класс извлекаем таблицу

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Connected!");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);


            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory;
    }
}
