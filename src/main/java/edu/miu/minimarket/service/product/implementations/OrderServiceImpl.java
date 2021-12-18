package edu.miu.minimarket.service.product.implementations;

import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.repository.product.OrderRepository;
import edu.miu.minimarket.service.product.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order,OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getSingleOrder(Long id) {
        return Objects.requireNonNull(orderRepository.findById(id)
                .map(order -> modelMapper.map(order, OrderDto.class))
                .orElse(null));
    }
}
