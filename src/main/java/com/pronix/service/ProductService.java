package com.pronix.service;

import com.pronix.entity.Product;
import com.pronix.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product){
        
        Product newProduct = productRepository.findById(id).orElse(null);
        
        if(newProduct != null){
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            newProduct.setQuantity(product.getQuantity());
            return productRepository.save(newProduct);
        } else {
            return null;
        }

    }
    
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
