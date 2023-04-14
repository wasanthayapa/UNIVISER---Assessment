package com.universe.inventoryMicroservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductDTO extends BaseDTO{

    private String productName;
    private BigDecimal productQty;
    private BigDecimal productPrice;
}
