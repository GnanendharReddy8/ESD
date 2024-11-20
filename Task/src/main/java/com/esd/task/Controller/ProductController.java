package com.esd.task.Controller;

import com.esd.task.Entity.ProductEntity;
import com.esd.task.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired private ProductService productService;

    @PostMapping("/create-product")
    public String createProduct(@RequestBody ProductEntity product) {
       return productService.createProduct(product);

    }

    @GetMapping("/show-product")
    public List<ProductEntity> showProduct() {
        return productService.getAllProducts();

    }

    @PutMapping("/update-product")
    public String updateProduct(@RequestBody ProductEntity product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }


    @GetMapping("/custom-product")
    public List<ProductEntity> customProduct() {
        return productService.customProduct();
    }
}
