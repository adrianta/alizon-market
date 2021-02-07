package com.alizon.alizonmarket.domain.service.impl;

import com.alizon.alizonmarket.domain.Purchase;
import com.alizon.alizonmarket.domain.repository.IPurchaseRepository;
import com.alizon.alizonmarket.web.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    @Override
    public Optional<List<Purchase>> getByCustomer(String customerId) {
        return purchaseRepository.getByCustomer(customerId);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
