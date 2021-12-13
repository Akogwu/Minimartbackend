package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.OrderDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderDto getSingleOrder(Long id) {
        return null;
    }

    @Override
    public void placeOrder(Long buyerId) {

    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public void changeOrderStatus(Long orderId) {

    }

    @Override
    public void deleteOrder(Long id) {

    }
}
