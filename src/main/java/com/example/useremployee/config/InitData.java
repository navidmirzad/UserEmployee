package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setEmail("navi0221@stud.kea.dk");
        user1.setPassword("navid");
        userRepository.save(user1);

        Employee employee1 = new Employee();
        employee1.setBorn(LocalDateTime.of(2000, 10, 29, 10, 12));
        employee1.setName("Navid");
        employee1.setGender(Gender.MALE);
        employee1.setVegetarian(false);
        employee1.setUser(user1);
        employeeRepository.save(employee1);

        User user2 = new User();
        user2.setEmail("zami0441@stud.kea.dk");
        user2.setPassword("ziba");
        userRepository.save(user2);



    }
}
