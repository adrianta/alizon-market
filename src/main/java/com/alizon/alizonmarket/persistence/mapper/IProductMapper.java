package com.alizon.alizonmarket.persistence.mapper;

import com.alizon.alizonmarket.domain.Product;
import com.alizon.alizonmarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICategoryMapper.class})
public interface IProductMapper {

    @Mappings({
            //@Mapping(source = "productId", target = "productId"),
            //@Mapping(source = "name", target = "name"),
            //@Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            //@Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntityList);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductEntity toProductEntity(Product product);
}
