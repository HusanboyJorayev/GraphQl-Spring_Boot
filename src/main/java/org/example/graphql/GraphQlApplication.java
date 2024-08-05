package org.example.graphql;

import org.example.graphql.entity.Product;
import org.example.graphql.entity.User;
import org.example.graphql.repository.ProductRepository;
import org.example.graphql.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(ProductRepository productRepository) {
        return args -> {
            for (int i = 1; i <= 20; i++) {
                Product product = Product.builder()
                        .price((float) (i * 20 / 2))
                        .type("type_" + i)
                        .userId(1 + i / 3)
                        .build();
                productRepository.save(product);
            }
        };
    }

    @Bean
    public CommandLineRunner runUser(UserRepository userRepository) {
        return args -> {
            for (int i = 1; i <= 20; i++) {
                User user = User.builder()
                        .age(i + 3)
                        .nickname("nickname_" + i)
                        .build();
                userRepository.save(user);
            }
        };
    }
}
