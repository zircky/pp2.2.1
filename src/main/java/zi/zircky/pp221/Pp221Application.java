package zi.zircky.pp221;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zi.zircky.pp221.config.AppConfig;
import zi.zircky.pp221.model.User;
import zi.zircky.pp221.service.UserService;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Pp221Application {

  public static void main(String[] args) throws SQLException {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);

    userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
    userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
    userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
    userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

    List<User> users = userService.listUsers();
    for (User user : users) {
      System.out.println("Id = "+user.getId());
      System.out.println("First Name = "+user.getFirstName());
      System.out.println("Last Name = "+user.getLastName());
      System.out.println("Email = "+user.getEmail());
      System.out.println();
    }

    context.close();
  }

}
