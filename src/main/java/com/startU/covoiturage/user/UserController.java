package com.startU.covoiturage.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return this.userService.login(user);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<User> getUsers(){
        return this.userService.getUsers();
    }
}
