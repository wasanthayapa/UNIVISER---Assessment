package com.universe.inventoryMicroservice.mapper;

import com.universe.inventoryMicroservice.dto.ProductDTO;
import com.universe.inventoryMicroservice.model.Product;

public class ProductMapper extends GenericMapper<ProductDTO, Product>{

    private static ProductMapper instance=null;
    public ProductMapper(){}
    public static ProductMapper getInstance(){
        if(instance==null){
            instance=new ProductMapper();
        }
        return instance;
    }

    @Override
    public void dtoToDomain(Product domain, ProductDTO dto) {
        domain.setId(dto.getId());
        domain.setName(dto.getProductName());
        domain.setPrice(dto.getProductPrice());
        domain.setQuantity(dto.getProductQty());
        setVersionAndIdToDomain(domain,dto);
    }

    @Override
    public ProductDTO domainToDto(Product domain) {
        ProductDTO dto=new ProductDTO();
        dto.setId(domain.getId());
        dto.setProductName(domain.getName());
        dto.setProductPrice(domain.getPrice());
        dto.setProductQty(domain.getQuantity());
        setVersionAndIdToDTO(dto,domain);
        return dto;
    }
}
