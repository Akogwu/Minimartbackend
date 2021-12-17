package edu.miu.minimarket.controller;

import edu.miu.minimarket.service.product.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
//    public List<OrderDto> getAllOrders(){
//        return orderService.getAllOrders();
//    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
