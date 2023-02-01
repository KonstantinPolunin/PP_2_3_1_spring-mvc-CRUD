package web.dao;



import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;


   @Override
   public void add(User user) {
      entityManager.merge(user);
   }


   @Override
   public List<User> getListUsers() {
      TypedQuery<User> query= entityManager.createQuery("SELECT user from User user", User.class);
      return query.getResultList();
   }


   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }





   @Override
   public void remove(Long id) {
      entityManager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
   }
}
