package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
    User findByUsername(String username);
    User findUserByUsername(String username);
}
