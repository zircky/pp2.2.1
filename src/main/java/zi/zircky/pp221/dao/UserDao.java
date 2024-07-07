package zi.zircky.pp221.dao;

import zi.zircky.pp221.model.User;

import java.util.List;

public interface UserDao {
  void add(User user);
  List<User> listUsers();
}
