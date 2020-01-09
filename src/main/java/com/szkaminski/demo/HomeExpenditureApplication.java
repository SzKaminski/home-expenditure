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

import java.math.BigDecimal;
import java.time.Year;
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
                new ArrayList<Bill>()/*, new ArrayList<Expenditure>()*/);


        ArrayList<Bill> bills = new ArrayList<>();

        User user = new User(null, "test",
                webSecurityConfiguration.passwordEncoder().encode("test123"),
                bills/*, new ArrayList<Expenditure>()*/);
        bills.add(new Bill(new ArrayList<>(),new ArrayList<>(),"home",new BigDecimal(0), Year.now(),Year.now().plusYears(2L)));
        bills.add(new Bill(new ArrayList<>(),new ArrayList<>(),"partys",new BigDecimal(24), Year.now(),Year.now().plusYears(2L)));

        userService.addUser(user);
        userService.addUser(admin);
        System.out.println(userService.findAll());
        System.out.println("Runner!");
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeExpenditureApplication.class, args);
    }
}
