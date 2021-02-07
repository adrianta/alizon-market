package com.alizon.alizonmarket.domain.repository;

import com.alizon.alizonmarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
