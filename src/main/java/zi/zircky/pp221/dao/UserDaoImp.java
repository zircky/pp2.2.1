package zi.zircky.pp221.dao;


import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zi.zircky.pp221.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void add(User user) {
    sessionFactory.getCurrentSession().save(user);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> listUsers() {
    TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
    return query.getResultList();
  }

}