package com.spring.security.sprngbootsecuritytest.controller;

import com.spring.security.sprngbootsecuritytest.model.AppUsers;
import com.spring.security.sprngbootsecuritytest.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private AppUserService service;

    @GetMapping("/home")
    public String home() {
        return "welcome...";
    }

    @GetMapping("/users")
    public List<AppUsers> allUsers() {
        return service.users();
    }

    @GetMapping("/user/{id}")
    public AppUsers getUserById(@PathVariable("id") int id) {
        return service.userById(id);
    }

    @PostMapping("/userAdd")
    public AppUsers addUser(@RequestBody AppUsers appUser) {
        service.addUser(appUser);
        return service.userById(appUser.getId());
    }

    @GetMapping("load")
    public String load() {
        service.load();
        return "loaded...";
    }

}
