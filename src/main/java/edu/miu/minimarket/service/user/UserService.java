package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User findByUserName(String username);
    void deleteUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void addRoleToUser(String username, String roleName);
}
