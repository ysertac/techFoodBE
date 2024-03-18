package com.techfood.service;

import com.techfood.entity.Role;
import com.techfood.entity.User;
import com.techfood.repository.RoleRepository;
import com.techfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);

        return userRepository.save(user);
    }
}
