package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Category;
import edu.miu.minimarket.model.product.OrderItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {
        List<OrderItem> findAll();
        List<OrderItem> findByOrderId(Long orderId);
        List<OrderItem> findByProductId(Long productId);

}
