package edu.miu.minimarket.controller;

import edu.miu.minimarket.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping

    public String hello(){
        return "Hello";
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
