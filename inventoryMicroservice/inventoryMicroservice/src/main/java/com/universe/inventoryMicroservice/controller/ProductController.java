package com.universe.inventoryMicroservice.controller;

import com.universe.inventoryMicroservice.dto.ProductDTO;
import com.universe.inventoryMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String index(){
        return "test";
    }
    @GetMapping("/find-by-id/{id}")
    public ProductDTO findProductById(Model model,@PathVariable("id") Integer id) throws Exception {
        ProductDTO productDTO=productService.findById(id);
        return  productDTO;
    }

    @GetMapping("/delete-by-id/{id}")
    public void deleteProductById(Model model,@PathVariable("id") Integer id) throws Exception {
       productService.delete(id);
    }
    @PostMapping("/save-product")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) throws Exception {
        productService.save(productDTO);
        return productDTO;
    }
    @GetMapping("/all-product")
    public List<ProductDTO> findAllProduct(Model model) throws Exception {
        return productService.findAll();
    }
}
