package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.service.product.CategoryService;
import edu.miu.minimarket.service.user.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private SellerService sellerService;
    private CategoryService categoryService;

    public SellerController(SellerService sellerService, CategoryService categoryService) {
        this.sellerService = sellerService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<SellerDto> getAllSellers(){
        return  sellerService.findAllSellers();
    }

    @GetMapping("/{id}")
    public SellerDto getSingleSeller(@PathVariable Long id){
        return sellerService.findSellerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id){
        sellerService.deleteSellerById(id);
    }

    @PutMapping
    public void updateSeller(@RequestBody Seller seller){
        sellerService.saveSeller(seller);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductDto productDto){
        sellerService.addProduct(productDto);
    }


}
