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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class AuthUserController {

    private BuyerService buyerService;
    private SellerService sellerService;
    private AdminService adminService;
    private UserService userService;


    @Autowired
    public AuthUserController(BuyerService buyerService, SellerService sellerService, AdminService adminService, UserService userService) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.adminService = adminService;
        this.userService = userService;
    }

    @PostMapping("/register/user")
    public void registerUser(@RequestBody User user){
        user.setRole(Role.valueOf(user.getRole().name()));
        userService.saveUser(user);
    }

    @PostMapping("/register/admin")
    public void registerAdmin(@RequestBody AdminDto adminDto){
        adminService.saveAdmin(adminDto);
    }

    @PostMapping("/register/buyer")
    public void registerBuyer(@RequestBody BuyerDto buyerDto){
        buyerService.saveBuyer(buyerDto);
    }

    @PostMapping("/register/seller")
    public void registerSeller(@RequestBody SellerDto sellerDto){
        sellerService.saveSeller(sellerDto);
    }


    //@PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsernameOrEmail(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,(UserPrincipal)authentication.getPrincipal()));
//    }

}
