package edu.miu.minimarket.service.product.implementations;

import edu.miu.minimarket.dto.CartItemDto;
import edu.miu.minimarket.model.product.CartItem;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.ShoppingCart;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.repository.product.ShoppingCartRepository;
import edu.miu.minimarket.service.product.ProductService;
import edu.miu.minimarket.service.product.ShoppingCartService;
import edu.miu.minimarket.service.user.BuyerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;
    private ProductService productService;
    private ModelMapper modelMapper;
    private BuyerService buyerService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductService productService, ModelMapper modelMapper, BuyerService buyerService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.buyerService = buyerService;
    }


    @Override
    public ShoppingCart addShoppingCart(CartItemDto cartItemDto) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByBuyer_Id(cartItemDto.getBuyer().getId());
        if (shoppingCart != null){
            System.out.println("not empty");
            List<CartItem> cartItems = shoppingCart.getItems();
           for (CartItem cartItem: cartItems){
               if (cartItem.getProduct().getId().equals(cartItemDto.getProduct().getId())) {
                   cartItem.setQuantity(cartItem.getQuantity() + cartItemDto.getQuantity());
                   shoppingCart.setItems(cartItems);
                   return shoppingCartRepository.save(shoppingCart);
               }
           }
        }else {
            shoppingCart = new ShoppingCart();
            cartItemDto.setProduct(modelMapper.map(productService.findProductById(cartItemDto.getProduct().getId()), Product.class));
            cartItemDto.setDate(new Date());
            shoppingCart.setCreatedDate(new Date());
            shoppingCart.setBuyer(cartItemDto.getBuyer());
            shoppingCart.getItems().add(modelMapper.map(cartItemDto, CartItem.class));
        }
        //shoppingCart.setTotalPrice(shoppingCart.getTotalPrice(shoppingCart.getItems()));
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCartById(Long shoppingCartId) {

    }

    @Override
    public ShoppingCart getShoppingCartByBuyerId(Long id) {
        return   shoppingCartRepository.findByBuyer_Id(id);
    }

    @Override
    public void removeThisItemFromShoppingCart(Long buyerId, Long cartItemId) {
             ShoppingCart shoppingCart = shoppingCartRepository.findByBuyer_Id(buyerId);
        System.out.println(buyerId+" "+cartItemId);
            List<CartItem> cartItems = shoppingCart.getItems();
        cartItems.stream().filter(cartItem1 -> Objects.equals(cartItem1.getId(), cartItemId)).findFirst().ifPresent(cartItems::remove);
        shoppingCart.setItems(cartItems);
            shoppingCartRepository.save(shoppingCart);
    }
}
