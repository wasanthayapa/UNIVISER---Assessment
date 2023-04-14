package com.universe.inventoryMicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name="tbl_product")
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="name", length=20, nullable=false)
    private String name;

    @Column(name="quantity", nullable=false)
    private BigDecimal quantity;

    @Column(name="price", nullable=false)
    private BigDecimal price;
}
