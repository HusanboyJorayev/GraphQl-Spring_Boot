package org.example.graphql.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.graphql.entity.Product;
import org.example.graphql.repository.ProductRepository;
import org.example.graphql.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return this.productRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Product updateProductById(Integer id, String type) {
        Product product = this.productRepository.findById(id)
                .orElse(null);
        if (product != null) {
            product.setType(type);
            this.productRepository.save(product);
        }
        return product;
    }
}
