package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserById(Long id);
   void update(Long id, User user);
   void remove(Long id);
}
