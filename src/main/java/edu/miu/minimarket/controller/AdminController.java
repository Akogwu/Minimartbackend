package edu.miu.minimarket.controller;

import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.service.user.AdminService;
import edu.miu.minimarket.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private UserService userService;

    @Autowired
    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }


    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/approve/seller/{id}")
    public void approveSeller(@PathVariable Long id){
        adminService.approveSeller(id);
    }

    @GetMapping("/reject/seller/{id}")
    public void rejectSeller(@PathVariable Long id){
        adminService.rejectSeller(id);
    }

    @DeleteMapping("/delete/seller/{id}")
    public void deleteSeller(@PathVariable Long id){
        adminService.deleteSeller(id);
    }



}
