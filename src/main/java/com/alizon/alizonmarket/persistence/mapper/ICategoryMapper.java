package com.alizon.alizonmarket.persistence.mapper;

import com.alizon.alizonmarket.domain.Category;
import com.alizon.alizonmarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    @Mappings({
            //@Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(Category category);
}
