package com.spring.security.sprngbootsecuritytest.service;

import com.spring.security.sprngbootsecuritytest.model.AppUsers;
import com.spring.security.sprngbootsecuritytest.model.MyUserDetailsService;
import com.spring.security.sprngbootsecuritytest.repositery.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AppUserService {

    @Autowired
    private AppUserRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDetailsService userRepo;
    public List<AppUsers> users() {
//        return "All users...";
        return repo.findAll();
    }

    public AppUsers userById (int id ) {

        Optional<AppUsers> j = repo.findById(id);
        return j.orElse(new AppUsers());
    }

    public void addUser(AppUsers appUser) {

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        repo.save(appUser);
    }

    public void load() {

        List<AppUsers> allUsers = new ArrayList<>(List.of(
                new AppUsers(1,"Surya","surya123","USER"),
                new AppUsers(2,"praveen","praveen123","USER"),
                new AppUsers(3,"vamsi","vamsi123","USER")
        ));
        repo.saveAll(allUsers);

    }
}
