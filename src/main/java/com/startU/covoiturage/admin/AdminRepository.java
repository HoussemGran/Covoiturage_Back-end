package com.startU.covoiturage.admin;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    List<Admin> findAdminByLoginAndPassword(String login , String password);

}
