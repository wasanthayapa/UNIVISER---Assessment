package com.universe.shoppingMicroservice.service;


import com.universe.shoppingMicroservice.api.InventoryApi;
import com.universe.shoppingMicroservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    InventoryApi inventoryApi;


    @Override
    public ProductDTO findById(Integer id) throws Exception {
        ProductDTO productDTO=inventoryApi.findById(id);
        return productDTO;
    }

    @Override
    public void save(ProductDTO productDTO) throws Exception {
        inventoryApi.save(productDTO);
    }

    @Override
    public void delete(Integer id) {
        inventoryApi.deleteById(id);

    }

    @Override
    public List<ProductDTO> findAll() throws Exception {
        List<ProductDTO> products= inventoryApi.findAllProduct();

        return  products;
    }
}
