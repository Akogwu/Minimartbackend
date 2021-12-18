package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.model.product.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getSingleOrder(Long id);
    void deleteOrder(Long id);
    void saveOrder(Order order);

}
