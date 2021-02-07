package com.alizon.alizonmarket.web.service;

import com.alizon.alizonmarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseService {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByCustomer(String customerId);
    Purchase save(Purchase purchase);
}
