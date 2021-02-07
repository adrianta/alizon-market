package com.alizon.alizonmarket.persistence.crud;

import com.alizon.alizonmarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);
    Optional<List<ProductEntity>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);
}
