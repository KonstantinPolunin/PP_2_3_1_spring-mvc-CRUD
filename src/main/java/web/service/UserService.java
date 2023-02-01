package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
   void add(User user);
   List<User> getListUsers();
   User getUserById(Long id);
   void remove(Long id);
}
