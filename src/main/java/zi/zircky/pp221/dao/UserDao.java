package zi.zircky.pp221.dao;

import java.util.List;

import zi.zircky.pp221.model.User;

public interface UserDao {
  void add(User user);
  List<User> listUsers();
  User getUserByCar(String model, int series);
}
