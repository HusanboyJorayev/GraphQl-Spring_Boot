package org.example.graphql.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.graphql.entity.Product;
import org.example.graphql.entity.User;
import org.example.graphql.repository.ProductRepository;
import org.example.graphql.repository.UserRepository;
import org.example.graphql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserWithProducts(Integer id) {
        User user = this.userRepository.findById(id)
                .orElse(null);
        List<Product> products = this.productRepository.findByUserId(id);
        if (user != null) {
            user.setProducts(products);
        }
        return user;
    }

    @Override
    public User updateUserById(Integer id, Integer age) {
        User user = this.userRepository.findById(id)
                .orElse(null);
        if (user != null) {
            user.setAge(age);
            this.userRepository.save(user);
        }
        return user;
    }

    @Override
    public String deleteUserById(Integer id) {
        User user = this.userRepository.findById(id)
                .orElse(null);
        if (user != null) {
            this.userRepository.delete(user);
            return "User delete successfully";
        }
        return "User is not found";
    }
}
