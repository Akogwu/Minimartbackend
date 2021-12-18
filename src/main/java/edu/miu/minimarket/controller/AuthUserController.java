package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.AdminDto;
import edu.miu.minimarket.model.AuthenticationRequest;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.security.JwtUtil;
import edu.miu.minimarket.service.user.AdminService;
import edu.miu.minimarket.service.user.BuyerService;
import edu.miu.minimarket.service.user.SellerService;
import edu.miu.minimarket.service.user.UserService;
import edu.miu.minimarket.service.user.implementations.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth/api")
public class AuthUserController {

    private BuyerService buyerService;
    private SellerService sellerService;
    private AdminService adminService;
    private UserService userService;
    private UserServiceImpl userServiceImpl;
    private AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    @Autowired
    public AuthUserController(BuyerService buyerService, SellerService sellerService, AdminService adminService, UserService userService, UserServiceImpl userServiceImpl, AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.adminService = adminService;
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/register/user")
    public void registerUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/register/admin")
    public void registerAdmin(@RequestBody AdminDto adminDto){
        adminService.saveAdmin(adminDto);
    }

    @PostMapping("/register/buyer")
    public void registerBuyer(@RequestBody Buyer buyer){
        buyerService.saveBuyer(buyer);
    }

    @PostMapping("/register/seller")
    public void registerSeller(@RequestBody Seller seller){
        sellerService.saveSeller(seller);
    }



    @PostMapping("/role/addToUser")

    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/authenticate", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> authenticateUser(AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userServiceImpl.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        Map<String,Object> tokens = new HashMap<>();
        tokens.put("access_token",token);
          tokens.put("user",userService.findUserByUsername(request.getUsername()) );
        return ResponseEntity.ok(tokens);
    }

}


@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}