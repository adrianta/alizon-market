package com.alizon.alizonmarket.persistence.repositoryimpl;

import com.alizon.alizonmarket.domain.Product;
import com.alizon.alizonmarket.domain.repository.IProductRepository;
import com.alizon.alizonmarket.persistence.crud.IProductCrudRepository;
import com.alizon.alizonmarket.persistence.entity.ProductEntity;
import com.alizon.alizonmarket.persistence.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
//@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository productCrudRepository;
    @Autowired
    private IProductMapper productMapper;

   /*public ProductRepository(final IProductCrudRepository productCrudRepository, final IProductMapper productMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
    }*/

    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProducts(products)) ;
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        //return products.map(prods -> productMapper.toProducts(prods));
        return products.map(productMapper::toProducts);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> productMapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
