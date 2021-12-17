package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long> {
    ShoppingCart findByBuyer_Id(Long id);
    ShoppingCart findBySessionToken(String sessionToken);
}
