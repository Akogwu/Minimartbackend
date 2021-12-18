package edu.miu.minimarket.service.user;
import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.model.product.CartItem;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.ShoppingCart;
import edu.miu.minimarket.model.user.Buyer;

import java.util.List;

public interface BuyerService {
    List<BuyerDto> findAllBuyers();
    BuyerDto findBuyerById(Long id);
    void deleteBuyerById(Long id);
    void saveBuyer(Buyer buyer);
    void updateBuyer(Buyer buyer);
    void followSeller(Long buyer_id, Long sellerId);
    void unFollowSeller(Long buyer_id, Long seller_id);
    void updateThisShoppingCart(Long buyerId, Long cartItemId, int quantity);
    void placeNewOrder(Order order);
}
