package com.szkaminski.demo;

import com.szkaminski.demo.backend.configurations.WebSecurityConfiguration;
import com.szkaminski.demo.backend.model.Bill;
import com.szkaminski.demo.backend.model.Expenditure;
import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class HomeExpenditureApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    WebSecurityConfiguration webSecurityConfiguration;

    @Override
    public void run(String... args) throws Exception {
        User admin = new User(null, "admin",
                webSecurityConfiguration.passwordEncoder().encode("passadm"),
                new ArrayList<Bill>(), new ArrayList<Expenditure>());
        User user = new User(null, "test",
                webSecurityConfiguration.passwordEncoder().encode("test123"),
                new ArrayList<Bill>(), new ArrayList<Expenditure>());

        userService.addUser(user);
        userService.addUser(admin);
        System.out.println(userService.findAll());
        System.out.println("Runner!");
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeExpenditureApplication.class, args);
    }
}
