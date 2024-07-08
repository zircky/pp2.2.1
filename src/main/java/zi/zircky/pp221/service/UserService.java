package zi.zircky.pp221.service;

import zi.zircky.pp221.model.User;

import java.util.List;

public interface UserService {
  void add(User user);
  List<User> listUsers();

  User getUserByCar(String model, int series);
}
