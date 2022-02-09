package rg.ragulajw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rg.ragulajw.data.models.User;
import rg.ragulajw.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user)
    {
        userRepository.save(user);
    }
}
