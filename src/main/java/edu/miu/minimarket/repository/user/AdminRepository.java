package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
    List<Admin> findAll();
}
