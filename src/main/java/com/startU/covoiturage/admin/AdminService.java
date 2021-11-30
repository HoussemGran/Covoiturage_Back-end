package com.startU.covoiturage.admin;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class AdminService{

    public static String getMD5(String data) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");

        messageDigest.update(data.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    @Autowired
    AdminRepository adminRepository;

    public ResponseEntity<Admin> login(Admin admin){

        String HashedPassword = null;
        try {
             HashedPassword = getMD5(admin.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return new ResponseEntity(e.getMessage() , HttpStatus.FAILED_DEPENDENCY);
        }
        List<Admin> admin1 = adminRepository.findAdminByLoginAndPassword(admin.getLogin(), HashedPassword) ;

        if(admin1.isEmpty()){
            return new ResponseEntity("No such admin",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Admin>(admin,HttpStatus.OK);
    }

}
