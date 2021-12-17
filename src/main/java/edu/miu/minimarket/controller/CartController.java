package edu.miu.minimarket.controller;

import edu.miu.minimarket.model.product.CartItem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

//    @PostMapping("/addToCart")
//    public String addToCart(HttpSession session, @RequestBody CartItem cartItem){
//
//        String sessionToken = (String) session.getAttribute("sessionToken");
//        if(sessionToken == null){
//            session.setAttribute("sessionToken", UUID.randomUUID().toString());
//        }else {
//
//        }
//    }


}
