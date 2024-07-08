package zi.zircky.pp221.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zi.zircky.pp221.dao.UserDao;
import zi.zircky.pp221.model.User;

@Service
public class UserServiceImp implements UserService{

  @Autowired
  private UserDao userDao;

  @Transactional
  @Override
  public void add(User user) {
     userDao.add(user);
  }

  @Transactional(readOnly = true)
  @Override
  public List<User> listUsers() {
     return userDao.listUsers();
  }

  @Transactional(readOnly = true)
  @Override
  public User getUserByCar(String model, int series) {
     return userDao.getUserByCar(model, series);
  }
}
