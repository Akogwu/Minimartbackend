package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long> {
    List<Buyer> findAll();
}
