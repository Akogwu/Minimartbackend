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

    //Buyer Order Operations

    @PostMapping
    public void addToCart(){

    }

    public void placeOrder(){

    }




}
