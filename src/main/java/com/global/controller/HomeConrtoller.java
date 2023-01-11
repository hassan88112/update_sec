package com.global.controller;

import com.global.Entity.Category;
import com.global.Service.CategoryService;
import com.global.Service.ProductService;
import com.global.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeConrtoller {


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping({"/","/home"})
    public String Home(Model model){

        return "index";
    }
    @GetMapping("/shop")
    public String Shop(Model model){


        model.addAttribute("categories" ,categoryService.getAllCategories());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProducts());

        return "shop";

    }
    @GetMapping("/shop/category/{id}")
    public String ShopByCategory(Model model, @PathVariable int id){


        model.addAttribute("categories" ,categoryService.getAllCategories());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProductByCategoryId(id));

        return "shop";

    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable long id){

        model.addAttribute("product",productService.getProductByID(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());

        return "viewProduct";

    }











}



