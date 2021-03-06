package edu.miu.minimarket.service.user;
import edu.miu.minimarket.dto.UserDto;
import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    UserDto findUserByUsername(String username);
    void deleteUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
