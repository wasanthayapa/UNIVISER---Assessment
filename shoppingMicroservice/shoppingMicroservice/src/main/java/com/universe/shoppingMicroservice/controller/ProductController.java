package com.universe.shoppingMicroservice.controller;

import com.universe.shoppingMicroservice.dto.ProductDTO;
import com.universe.shoppingMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping(("/product"))
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) throws Exception {
        model.addAttribute("products",productService.findAll());
        return "/product/table-view";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product",new ProductDTO());
        return "/product/add-view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Integer integer) throws Exception {
        productService.delete(integer);
        model.addAttribute("products",productService.findAll());
        return "/product/table-view";

    }

    @GetMapping("/find-by-id/{id}")
    public String findProductById(Model model, @PathVariable("id") Integer integer) throws Exception {
        ProductDTO dto= productService.findById(integer);
        model.addAttribute("product",dto);

        return "/product/add-view";

    }

    @GetMapping("/find-all")
    public String findAllProduct(Model model) throws Exception {
        model.addAttribute("products",productService.findAll());
        return "/product/table-view";

    }

    @PostMapping("/save")
    public String saveProducts(ProductDTO productDTO,Model model) throws Exception {
        productService.save(productDTO);
        model.addAttribute("products",productService.findAll());

        return "/product/table-view";

    }
}
