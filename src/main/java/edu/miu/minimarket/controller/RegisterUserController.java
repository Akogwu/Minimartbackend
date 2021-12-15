package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.AdminDto;
import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.service.user.AdminService;
import edu.miu.minimarket.service.user.BuyerService;
import edu.miu.minimarket.service.user.SellerService;
import edu.miu.minimarket.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    private BuyerService buyerService;
    private SellerService sellerService;
    private AdminService adminService;
    private UserService userService;


    @Autowired
    public RegisterUserController(BuyerService buyerService, SellerService sellerService, AdminService adminService, UserService userService) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.adminService = adminService;
        this.userService = userService;
    }

    @PostMapping("/user")
    public void registerUser(@RequestBody User user){
        user.setRole(Role.valueOf(user.getRole().name()));
        userService.saveUser(user);
    }

    @PostMapping("/admin")
    public void registerAdmin(@RequestBody AdminDto adminDto){
        adminService.saveAdmin(adminDto);
    }

    @PostMapping("/buyer")
    public void registerBuyer(@RequestBody BuyerDto buyerDto){
        buyerService.saveBuyer(buyerDto);
    }

    @PostMapping("/seller")
    public void registerSeller(@RequestBody SellerDto sellerDto){
        sellerService.saveSeller(sellerDto);
    }
}
