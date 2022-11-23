package com.example.estore.controller;

import com.example.estore.entity.Category;
import com.example.estore.entity.Product;
import com.example.estore.repository.CategoryRepository;
import com.example.estore.repository.ProductRepository;
import com.example.estore.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    CookieService cookie;
    @GetMapping("/getAllProduct")
    private List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("product/{id}")
    private Product findCategoryById(@PathVariable int id){
        return productRepository.findById(id).get();
    }
    @GetMapping("list-by-category/{cid}")
    private List<Product> listByCategory(@PathVariable int cid){
        Category cate = categoryRepository.findById(cid).get();
        List<Product> list = cate.getProducts();
        return list;
    }
    @ResponseBody
    @RequestMapping("addToCart/{productId}")
    public Boolean addToCart(@PathVariable("productId") Integer productId){
        Cookie cart = cookie.read("cart");
        String value = productId.toString();
        if(cart != null){
            value = cart.getValue();
            if(!value.contains(productId.toString())){
                value += ","+productId.toString();
            }else {
                return false;
            }
        }
        cookie.create("cart",value,30);
        return true;
    }
    @RequestMapping("/readCookie")
    public String test() throws IOException {
//        Cookie cart = cookie.read("cart");
//        String value = productId.toString();
//        if(cart != null){
//            value = cart.getValue();
//            if(!value.contains(productId.toString())){
//                value += ","+productId.toString();
//            }else {
//                return false;
//            }
//        }
//        Cookie c = new Cookie("username","test");
//        c.setMaxAge(60*60/24);
//        c.setPath("/");
//        response.addCookie(c);
//        response.getWriter().append("OK").append(request.getContextPath());

        Cookie cart = cookie.read("cart");
        String ids = cart.getValue();
        return ids;



    }
}
