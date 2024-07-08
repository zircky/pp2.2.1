package zi.zircky.pp221.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import zi.zircky.pp221.model.User;

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
     TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
     return query.getResultList();
  }

  @Override
  @SuppressWarnings("unchecked")
  public User getUserByCar(String model, int series) {
     String hql = "from User user where user.car.model = :model and user.car.series = :series";
     TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
     query.setParameter("model", model).setParameter("series", series);
     return query.setMaxResults(1).getSingleResult();
  }
}