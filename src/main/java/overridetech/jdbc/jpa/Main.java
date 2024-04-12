package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Anastasiya", "Novikova", (byte) 34);
        userServiceImpl.saveUser("Tatiyna", "Prakht", (byte) 36);
        userServiceImpl.saveUser("Galina", "Vrabie", (byte) 38);
        userServiceImpl.saveUser("Roman", "Garifullin", (byte) 31);

        List<User> userList = userServiceImpl.getAllUsers();
        System.out.println(userList);
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();

    }
}
