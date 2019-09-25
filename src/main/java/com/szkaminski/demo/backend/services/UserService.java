package com.szkaminski.demo.backend.services;

import com.szkaminski.demo.backend.model.CustomUserDetails;
import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByName(s));

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("name not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
