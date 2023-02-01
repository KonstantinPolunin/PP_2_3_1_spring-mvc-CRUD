package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
//@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersTable(Model model) {
        model.addAttribute("userList", userService.getListUsers());
        return "users";
    }
    /*@GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }*/
    @GetMapping(value = "/user")
    public String getUserById( @RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }
    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
    /*@GetMapping(value = "/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }*/
    @GetMapping(value = "/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    /*@PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/";
    }*/

    /*@GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/";
    }*/
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.remove(id);
        return "redirect:/";
    }
}
