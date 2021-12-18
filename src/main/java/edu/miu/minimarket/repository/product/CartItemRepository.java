package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Long> {

}
