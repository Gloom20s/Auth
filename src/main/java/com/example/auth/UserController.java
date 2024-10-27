package com.example.auth;

import com.example.auth.User;
import com.example.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username, password);
        return user != null ? "Login successful" : "Invalid credentials";
    }

    @GetMapping("/user/{id}")
    public User getUserDetails(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
