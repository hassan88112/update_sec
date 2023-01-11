package com.global.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.global.Entity.Product;
import com.global.Service.CategoryService;
import com.global.Service.ProductService;
import com.global.dto.ProductDTO;

@Controller
public class ProductController {

	// public static String uploadDir= "D:/projects/src/main/resources/static/productImages";
	
	private final ProductService productService;
	private final CategoryService categoryService;

	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}


	@GetMapping("/admin/products")
	public String getProducts(Model model){
    model.addAttribute("products",productService.getAllProducts());
        return "products";
    }
	
	@GetMapping("/admin/products/add")  //action bt2 button da byro7 ly /admin/categories/add
	public String productAdd(Model model){

		model.addAttribute("productDTO",new ProductDTO());
		model.addAttribute("categories" ,categoryService.getAllCategories());
		
        return "productsAdd";
    }

	@PostMapping("/admin/products/add")  // da by add category gdeed
	public String postProdAdd(@ModelAttribute ("productDTO") ProductDTO productDTO) throws IOException{


		Product product=new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setWeight(productDTO.getWeight());
		product.setCategory(categoryService.grtCatById(productDTO.getCategoryId()).get());
	//	String imageUUID;  // universally unique identifier
		productService.addProduct(product);
		
        return "redirect:/admin/products";
    }

	@GetMapping("/admin/product/delete/{id}")
	public String deleteproduct(@PathVariable Long id ){

		productService.deleteproById(id);
		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/update/{id}")
	public  String updateProduct(@PathVariable Long id ,Model model) {

		   Product p = productService.getProductByID(id).get();

			ProductDTO productDTO=new ProductDTO();
			productDTO.setId(p.getId());
			productDTO.setName(p.getName());
			productDTO.setWeight(p.getWeight());
			productDTO.setPrice(p.getPrice());
			productDTO.setDescription(p.getDescription());
			productDTO.setCategoryId((p.getCategory().getId()));

			model.addAttribute("categories",categoryService.getAllCategories());
			model.addAttribute("productDTO",productDTO);
			return "productsAdd";



	}

}
