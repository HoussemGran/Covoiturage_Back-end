package com.startU.covoiturage.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(path = "/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin){
        return this.adminService.login(admin);
    }

}
