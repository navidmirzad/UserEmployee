package com.example.useremployee.controller;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/employees")
    List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    /*@DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Optional<User> originalUser = userRepository.findById(id);
        if (originalUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("user deleted");
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }*/


}
