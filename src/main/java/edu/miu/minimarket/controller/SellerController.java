package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.service.user.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private SellerService sellerService;
    private ModelMapper modelMapper;

    public SellerController(SellerService sellerService, ModelMapper modelMapper) {
        this.sellerService = sellerService;
        this.modelMapper = modelMapper;
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
    public void updateSeller(@RequestBody SellerDto sellerDto){
        sellerService.saveSeller(sellerDto);
    }


}
