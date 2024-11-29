package com.example.ERP.Controller;

import com.example.ERP.Entity.User;
import com.example.ERP.Repository.IUserRepo;
import com.example.ERP.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserRepo userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Encrypt password
        user.setPassword(PasswordUtil.encryptPassword(user.getPassword()));

        // Save user to the database
        userRepository.save(user);

        return ResponseEntity.ok("User created successfully!");
    }
}
