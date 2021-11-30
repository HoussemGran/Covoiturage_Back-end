package com.startU.covoiturage.user;

import com.startU.covoiturage.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

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
    UserRepository userRepository;

    public ResponseEntity<User> login(User user){

        String HashedPassword = null;

        try {
            HashedPassword = getMD5(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return new ResponseEntity("Failed to hash password", HttpStatus.FAILED_DEPENDENCY);
        }

        List<User> user1 = userRepository.findUserByLoginAndPassword(user.getLogin(), HashedPassword);

        if(user1.isEmpty()){
            return new ResponseEntity("No such user",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<User>(user1.get(0),HttpStatus.OK);
    }

    public ResponseEntity<User> addUser(User user){

        List<User> userByLogin = userRepository.findUserByLogin(user.getLogin());

        if (!userByLogin.isEmpty()) {
            new ResponseEntity("user already exist",HttpStatus.NO_CONTENT);
        }

        String hashedPassword = null;

        try {
            hashedPassword = getMD5(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setPassword(hashedPassword);

        return new ResponseEntity(userRepository.save(user),HttpStatus.OK);
    }

    public ResponseEntity<User> getUsers(){
        if (userRepository.findAll().isEmpty()) {
            return new ResponseEntity("There is no users",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(userRepository.findAll(),HttpStatus.OK);
    }

}
