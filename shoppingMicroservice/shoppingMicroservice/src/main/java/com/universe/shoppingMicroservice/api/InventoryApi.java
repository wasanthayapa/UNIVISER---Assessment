package com.universe.shoppingMicroservice.api;

import com.universe.shoppingMicroservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class InventoryApi {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment environment;

    public List<ProductDTO> findAllProduct(){

        ResponseEntity<ProductDTO[]> response =
                restTemplate.getForEntity(getApiUrl(environment.getProperty("inventory.api.find-all"))
                        ,
                        ProductDTO[].class);
        ProductDTO[] responseBody = response.getBody();
        return Arrays.asList(responseBody);

    }
    public ProductDTO findById(Integer id){
;
        return  restTemplate.getForObject(getApiUrl(environment.getProperty("inventory.api.find-by-id")+id),
                ProductDTO.class);

    }
    public ProductDTO deleteById(Integer id){
        ;
        return  restTemplate.getForObject(
                getApiUrl(environment.getProperty("inventory.api.delete-by-id")+id),
                ProductDTO.class);
    }

    public void save(ProductDTO productDTO){
         ProductDTO dto=restTemplate.postForObject(getApiUrl(environment.getProperty("inventory.api.save")), productDTO, ProductDTO.class);
    }

    private String getApiUrl(String route){
        return environment.getProperty("inventory.host")+":"+environment.getProperty("inventory.port")+route;
    }
}
