package com.alizon.alizonmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    private int categoryId;
    private String category;
    private boolean active;
}
