package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.service.user.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
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



    @PostMapping
    public void addToCart(){

    }

    public void placeOrder(){

    }




}
