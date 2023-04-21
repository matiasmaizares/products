package com.example.challengue.service;

import com.example.challengue.model.Product;
import com.example.challengue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "precio"));
    }
    public Product getById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getByNombre(String nombre){
        return productRepository.findByNombre(nombre).orElse(null);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
}
