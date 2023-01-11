package com.global.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Product;
import com.global.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
		
		return productRepository.findAll();
	}
    public void addProduct(Product product) {
		
		productRepository.save(product);
	
	}
    
    public Optional<Product> getProductByID(Long id) {
    	
    	return productRepository.findById(id);
    }
    
    
    public List<Product> getAllProductByCategoryId(int id){
    	
    	return productRepository.findAllByCategory_Id(id);
    }
	public void deleteproById(Long id){

		productRepository.deleteById(id);
	}
	
}
