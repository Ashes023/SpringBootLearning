package com.ashahar.simpleWebApp.service;

import com.ashahar.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(101, "IPhone", 75000),
            new Product(102,"Camera",60000)
    ));

    public List<Product> getAllProducts() {
        return products;
    }


    public Product getProductById(int id) {
        return products.stream().filter(p-> p.getProdId() == id).findFirst().orElse(new Product(100, "No Product", 404));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for(int x = 0; x < products.size(); x++){
            if(products.get(x).getProdId() == product.getProdId()){
                products.set(x, product);
                break;
            }
        }
    }

    public void deleteProduct(int prodId) {
        for(int x = 0; x < products.size(); x++){
            if(products.get(x).getProdId() == prodId){
                products.remove(x);
                break;
            }
        }
    }
}
