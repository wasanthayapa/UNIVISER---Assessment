package com.universe.inventoryMicroservice.dao;

import com.universe.inventoryMicroservice.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {

}
