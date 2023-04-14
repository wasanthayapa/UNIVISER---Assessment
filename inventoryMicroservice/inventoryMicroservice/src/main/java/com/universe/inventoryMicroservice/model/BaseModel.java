package com.universe.inventoryMicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Version
    @Column(name="version")
    private Integer version;

}
