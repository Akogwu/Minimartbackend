package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
