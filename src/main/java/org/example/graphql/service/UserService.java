package org.example.graphql.service;

import org.example.graphql.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> getAllUsers();

    User getUserWithProducts(Integer id);

    User updateUserById(Integer id,Integer age);

    String deleteUserById(Integer id);
}
