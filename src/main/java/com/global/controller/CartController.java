package com.global.controller;

import com.global.Entity.Product;
import com.global.Service.ProductService;
import com.global.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
 class CartController {
    @Autowired
    ProductService productService;


    @GetMapping("/addToCart/{id}")
    public String AddToCart(@PathVariable Long id){

        GlobalData.cart.add(productService.getProductByID(id).get());

        return  "redirect:/shop";
    }
    @GetMapping("/cart")
    public String CartGet(Model model){

        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice));
        model.addAttribute("cart",GlobalData.cart);
        return  "cart";

    }
}
