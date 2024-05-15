package com.spring.security.sprngbootsecuritytest.repositery;

import com.spring.security.sprngbootsecuritytest.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUsers,Integer> {

    Optional<AppUsers> findByUsername(String username);
}
