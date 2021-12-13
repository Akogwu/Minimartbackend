package edu.miu.minimarket.repository.product;
import edu.miu.minimarket.model.product.Cart;
import edu.miu.minimarket.model.user.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends CrudRepository<Cart,Long> {
    List<Cart> findAllByBuyerOrderByCreatedDateDesc(Buyer buyer);
    List<Cart> deleteByBuyer(Buyer buyer);
}
