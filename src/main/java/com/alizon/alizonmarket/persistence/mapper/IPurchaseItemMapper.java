package com.alizon.alizonmarket.persistence.mapper;

import com.alizon.alizonmarket.domain.PurchaseItem;
import com.alizon.alizonmarket.persistence.entity.PurchasesProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IProductMapper.class})
public interface IPurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchasesProductEntity products);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchasesProductEntity toPurchasesProductEntity(PurchaseItem item);
}
