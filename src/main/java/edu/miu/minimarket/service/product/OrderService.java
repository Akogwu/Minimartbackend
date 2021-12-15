package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.dto.PlaceOrderDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface OrderService {

    List<OrderDto> getAllOrders();
    OrderDto getSingleOrder(Long id);
    void placeOrder(PlaceOrderDto placeOrderDto);
    void cancelOrder(Long orderId);
    void changeOrderStatus(Long orderId);
    void deleteOrder(Long id);

}
