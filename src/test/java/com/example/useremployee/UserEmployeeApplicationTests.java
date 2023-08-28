package com.example.useremployee;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserEmployeeApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void TestOneNavid() {
        List<Employee> employeeList = employeeRepository.findEmployeeByName("Navid");
        assertTrue(employeeList.size() > 0);
    }

    @Test
    void testDeleteUser() {
        Optional<User> userList = userRepository.findByEmail("navi0221@stud.kea.dk");

        User user1 = new User();
        if (userList.isPresent()) {
            user1 = userList.get();
        }
        Class cls = "hej".getClass();
        var obj = cls.getClass();

        final User user2 = user1;
        assertThrows(DataIntegrityViolationException.class, () -> userRepository.delete(user2));
    }

    @Test
    void createUser() {

    }

}
