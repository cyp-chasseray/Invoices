package com.example.billeditor.service;

import com.example.billeditor.entity.Product;
import com.example.billeditor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> fetchAllProductsByIdList(List<Long> ids){return productRepository.findAllByIdIn(ids);}

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> fetchAllProductsById(long id) {return productRepository.findAllByUserId(id);}

}
