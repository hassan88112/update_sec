package com.global.global;

import com.global.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Product> cart;
    static {

        cart =new ArrayList<Product>();
    }
}
