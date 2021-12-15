package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.dto.PlaceOrderDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderItem;
import edu.miu.minimarket.repository.product.OrderRepository;
import edu.miu.minimarket.repository.user.BuyerRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderDto getSingleOrder(Long id) {
        return null;
    }

    @Override
    public void placeOrder(PlaceOrderDto placeOrderDto) {
        
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        
        //placeOrderDto.getItems().stream().map(item->item.getId)
                //->{ 
//            OrderItem orderItem = new OrderItem(Long.MAX_VALUE,dtoItem.ge , 0, 0, Long.MIN_VALUE, Long.MIN_VALUE, LocalDate.MAX);
//            orderItems.add(orderItem);
//        });
        
        Order order = new Order(Long.MAX_VALUE, LocalDate.now(), "success", placeOrderDto.getPrice(), buyerRepository.findById(placeOrderDto.getBuyerId()).get(), new ArrayList<OrderItem>());
        
        orderRepository.save(order);
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
