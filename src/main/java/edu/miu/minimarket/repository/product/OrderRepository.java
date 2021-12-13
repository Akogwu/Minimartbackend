package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findAll();
    List<Order> findAllByBuyerIdOrderByCreatedDateDesc(Long buyerId);
}
