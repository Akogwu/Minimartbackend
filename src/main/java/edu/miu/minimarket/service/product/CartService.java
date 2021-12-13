package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.AddToCartDto;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.user.Buyer;

import java.util.List;

public interface CartService {
    void addToCart(AddToCartDto addToCartDto, Product product, Buyer buyer);

}
