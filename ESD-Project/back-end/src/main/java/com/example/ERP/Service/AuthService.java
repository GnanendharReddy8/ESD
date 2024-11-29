package com.example.ERP.Service;

import com.example.ERP.Entity.User;
import com.example.ERP.Repository.IUserRepo;
import com.example.ERP.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private IUserRepo userRepository;

    public User authenticate(String username, String rawPassword) {
        // Fetch user from the database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // Validate password
        if (!PasswordUtil.matchPassword(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return user; // Return authenticated user
    }
}
