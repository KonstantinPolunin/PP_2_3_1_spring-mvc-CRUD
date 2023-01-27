package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
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
   public List<User> listUsers() {
      Query<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public User getUserById(Long id) {
      return sessionFactory.getCurrentSession().get(User.class, id);
   }


   @Override
   public void update(Long id, User user) {
      User userForUpdate = getUserById(id);
      userForUpdate.setName(user.getName());
      userForUpdate.setAge(user.getAge());
   }


   @Override
   public void remove(Long id) {
      sessionFactory.getCurrentSession().delete(getUserById(id));

   }


}
