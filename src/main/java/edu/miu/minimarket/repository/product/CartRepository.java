package edu.miu.minimarket.repository.product;
import edu.miu.minimarket.model.product.ShoppingCart;
import edu.miu.minimarket.model.user.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends CrudRepository<ShoppingCart,Long> {
    List<ShoppingCart> findAllByBuyerOrderByCreatedDateDesc(Buyer buyer);
    List<ShoppingCart> deleteByBuyer(Buyer buyer);
}
