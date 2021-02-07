package com.alizon.alizonmarket.persistence.repositoryimpl;

import com.alizon.alizonmarket.domain.Purchase;
import com.alizon.alizonmarket.domain.repository.IPurchaseRepository;
import com.alizon.alizonmarket.persistence.crud.IPurchaseCrudRepository;
import com.alizon.alizonmarket.persistence.entity.PurchaseEntity;
import com.alizon.alizonmarket.persistence.mapper.IPurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private IPurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private IPurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCustomer(String customerId) {
        return purchaseCrudRepository.findByCustomerId(customerId).map(prods -> mapper.toPurchases(prods));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.getProducts().forEach(prods -> prods.setPurchase(purchaseEntity));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}
