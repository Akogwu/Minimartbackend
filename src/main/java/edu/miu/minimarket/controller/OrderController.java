package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.dto.PlaceOrderDto;
import edu.miu.minimarket.service.product.OrderService;
import edu.miu.minimarket.service.product.OrderServiceImpl;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderServiceImpl = orderService;
//    }
/*
    @RequestParam(value = "sdate") String startDate,
            @RequestParam(value = "edate") String endDate,
            @RequestParam(value = "p") Optional<Integer> page,
            @RequestParam(value = "s") Optional<Integer> size,
    */
    @PostMapping("/create")
    
    public Map<String, Object> placeOrder(@RequestParam(value = "items") String item ){
        System.out.print(item);
        Map<String, Object>map = new HashMap<>();
        //orderServiceImpl.placeOrder(placeOrderDto);
        return map;
    }

    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderServiceImpl.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderServiceImpl.deleteOrder(id);
    }

}
