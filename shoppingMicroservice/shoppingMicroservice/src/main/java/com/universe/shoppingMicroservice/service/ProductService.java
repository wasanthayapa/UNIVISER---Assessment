package com.universe.shoppingMicroservice.service;

import com.universe.shoppingMicroservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO findById(Integer id) throws Exception;

    void save(ProductDTO productDTO) throws Exception;

    void delete(Integer id);

    List<ProductDTO> findAll()throws Exception;

}
