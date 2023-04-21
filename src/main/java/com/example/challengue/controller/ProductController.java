package com.example.challengue.controller;

import com.example.challengue.model.Product;
import com.example.challengue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product= productService.getById(id);
        if (product==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getByNombre(@PathVariable String name){
        Product product= productService.getByNombre(name);
        if (product==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
        Product productDB= productService.getById(id);
        if (product==null){
            return ResponseEntity.notFound().build();
        }
        productDB.setNombre(product.getNombre());
        productDB.setPrecio(product.getPrecio());
        productDB.setCantidad(product.getCantidad());
        productDB.setDescripcion(product.getDescripcion());
        return ResponseEntity.ok(productService.save(productDB));
    }
}
