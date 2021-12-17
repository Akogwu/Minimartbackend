package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.CartItemDto;
import edu.miu.minimarket.model.product.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addShoppingCart(CartItemDto cartItemDto);
    void deleteShoppingCartById(Long shoppingCartId);
    ShoppingCart getShoppingCartByBuyerId(Long id);
    void removeThisItemFromShoppingCart(Long buyerId, Long cartItemId);
}
