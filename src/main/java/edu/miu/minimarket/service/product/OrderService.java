package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.OrderDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();
    OrderDto getSingleOrder(Long id);
    void placeOrder(Long buyerId);
    void cancelOrder(Long orderId);
    void changeOrderStatus(Long orderId);
    void deleteOrder(Long id);

}
