package com.alizon.alizonmarket.persistence.crud;

import com.alizon.alizonmarket.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {

    Optional<List<PurchaseEntity>> findByCustomerId(String customerId);
}
