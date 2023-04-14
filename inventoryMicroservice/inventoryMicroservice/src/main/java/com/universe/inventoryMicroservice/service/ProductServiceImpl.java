package com.universe.inventoryMicroservice.service;

import com.universe.inventoryMicroservice.dao.ProductDao;
import com.universe.inventoryMicroservice.dto.ProductDTO;
import com.universe.inventoryMicroservice.mapper.ProductMapper;
import com.universe.inventoryMicroservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public ProductDTO findById(Integer id) throws Exception {
        Product product=productDao.findById(id).get();
        ProductDTO dto= ProductMapper.getInstance().domainToDto(product);
        return dto;
    }

    @Override
    public void save(ProductDTO productDTO) throws Exception {
        Product product;
        if(productDTO!=null && productDTO.getId()!=null ){
            product= productDao.findById(productDTO.getId()).get();
        }else{
            product= new Product();
        }
        ProductMapper.getInstance().dtoToDomain(product,productDTO);
        productDao.save(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.deleteById(id);

    }

    @Override
    public List<ProductDTO> findAll() throws Exception {
        List<Product> products= (List<Product>) productDao.findAll();

        return  ProductMapper.getInstance().domainToDTOCollection(products);
    }
}
