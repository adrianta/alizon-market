package com.alizon.alizonmarket.persistence.mapper;

import com.alizon.alizonmarket.domain.Purchase;
import com.alizon.alizonmarket.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPurchaseItemMapper.class})
public interface IPurchaseMapper {

    @Mapping(source = "status", target = "state")
    @Mapping(source = "products", target = "items")
    Purchase toPurchase(PurchaseEntity purchaseEntity);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
