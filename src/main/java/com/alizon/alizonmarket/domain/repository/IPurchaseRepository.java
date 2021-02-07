package com.alizon.alizonmarket.domain.repository;

import com.alizon.alizonmarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByCustomer(String clientId);
    Purchase save(Purchase purchase);
}
