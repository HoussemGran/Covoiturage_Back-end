package com.startU.covoiturage.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUserByLoginAndPassword(String login , String password);
    List<User> findUserByLogin(String login);

}
