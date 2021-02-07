package com.alizon.alizonmarket.domain.service.impl;

import com.alizon.alizonmarket.domain.Product;
import com.alizon.alizonmarket.domain.repository.IProductRepository;
import com.alizon.alizonmarket.web.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
