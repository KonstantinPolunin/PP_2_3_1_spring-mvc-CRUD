package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Transactional
   @Override
   public User getUserById(Long id) {
      return sessionFactory.getCurrentSession().get(User.class, id);
   }

   @Transactional
   @Override
   public void update(Long id, User user) {
      User userForUpdate = getUserById(id);
      userForUpdate.setName(user.getName());
      userForUpdate.setAge(user.getAge());
   }

   @Transactional
   @Override
   public void remove(Long id) {
      sessionFactory.getCurrentSession().remove(getUserById(id));

   }


}
