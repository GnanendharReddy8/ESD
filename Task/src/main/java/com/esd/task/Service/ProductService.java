package com.esd.task.Service;

import com.esd.task.Entity.ProductEntity;
import com.esd.task.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepo productRepo;

    public String createProduct(ProductEntity product) {
        try{
            productRepo.save(product);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return "Product created";
    }

    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }
    public String updateProduct(ProductEntity product) {
        ProductEntity prod = productRepo.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        productRepo.save(prod);
        return "Product updated";
    }
    public String deleteProduct(Long id) {
        try {
            productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            productRepo.deleteById(id);
        }
        catch(Exception e){return e.getMessage();}
        return "Product deleted";
    }

    public List<ProductEntity> customProduct(){
        return productRepo.customProduct();
    }
}
