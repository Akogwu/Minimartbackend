package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.dto.CartItemDto;
import edu.miu.minimarket.dto.OrderDto;
import edu.miu.minimarket.model.product.CartItem;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.ShoppingCart;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.service.product.ShoppingCartService;
import edu.miu.minimarket.service.user.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private BuyerService buyerService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public BuyerController(BuyerService buyerService, ShoppingCartService shoppingCartService) {
        this.buyerService = buyerService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<BuyerDto> getAllBuyers(){
        return buyerService.findAllBuyers();
    }
    
    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable("id") Long buyerId){
        buyerService.deleteBuyerById(buyerId);
    }

    @PostMapping("/update")
    public void updateBuyer(@RequestBody Buyer buyer){
        buyerService.updateBuyer(buyer);
    }

    @GetMapping("/{id}")
    public BuyerDto getSingleBuyer(@PathVariable Long id){
        return buyerService.findBuyerById(id);
    }

    //Buyer Order Operations

    @GetMapping("/{buyer_id}/follow/seller/{seller_id}")
    public void followSeller(@PathVariable Long buyer_id,@PathVariable Long seller_id){
        buyerService.followSeller(buyer_id,seller_id);
    }

    @GetMapping("/{buyer_id}/unfollow/seller/{seller_id}")
    public void unFollowSeller(@PathVariable Long buyer_id,@PathVariable Long seller_id){
        buyerService.unFollowSeller(buyer_id,seller_id);
    }

    @PostMapping("/addProductToCart")
    public void addProductToCart(@RequestBody CartItemDto cartItemDto){
        shoppingCartService.addShoppingCart(cartItemDto);
    }

    @GetMapping("/{id}/shoppingCart")
    public ShoppingCart getThisBuyerShoppingCart(@PathVariable Long id){
        return shoppingCartService.getShoppingCartByBuyerId(id);
    }

    @GetMapping("/{buyerId}/update/CartItem/{cartItemId}/quantity/{quantity}")
    public void updateThisCartItem(@PathVariable Long buyerId, @PathVariable Long cartItemId, @PathVariable int quantity){
        buyerService.updateThisShoppingCart(buyerId,cartItemId,quantity);
    }


    @GetMapping("/{buyerId}/remove/CartItem/{cartItemId}")
    public void removeThisCartItemFromShopping(@PathVariable Long buyerId, @PathVariable Long cartItemId){
        shoppingCartService.removeThisItemFromShoppingCart(buyerId,cartItemId);
    }

    @PostMapping("/placeOrder")
    public void addOrder(@RequestBody Order order){
        buyerService.placeNewOrder(order);
    }

//    @GetMapping("/viewCart/{id}")
//    public List<CartItem> getThisBuyerShoppingCart(@PathVariable Long id){
//        return buyerService.viewBuyerCart(id);
//    }


}
