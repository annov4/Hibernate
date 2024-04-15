package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.service.UserService;
import overridetech.jdbc.jpa.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Anastasiya", "Novikova", (byte) 34);
        userService.saveUser("Tatiyna", "Prakht", (byte) 36);
        userService.saveUser("Galina", "Vrabie", (byte) 38);
        userService.saveUser("Roman", "Garifullin", (byte) 31);

        List<User> userList = userService.getAllUsers();
        System.out.println(userList);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
