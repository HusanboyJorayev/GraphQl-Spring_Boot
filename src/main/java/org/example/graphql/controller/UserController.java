package org.example.graphql.controller;

import lombok.RequiredArgsConstructor;
import org.example.graphql.entity.User;
import org.example.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @QueryMapping()
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @QueryMapping()
    public User getUserWithProducts(@Argument Integer id) {
        return this.userService.getUserWithProducts(id);
    }

    @MutationMapping
    public User updateUserById(@Argument Integer id, @Argument Integer age) {
        return this.userService.updateUserById(id, age);
    }

    @MutationMapping
    public String deleteUserById(@Argument Integer id) {
        return this.userService.deleteUserById(id);
    }
}
