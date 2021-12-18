package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long> {
    List<Buyer> findAll();

    @Query("SELECT b.sellers FROM Buyer b WHERE b.id = :buyerId")
    List<Seller> findSellersFollowedByThisBuyer(Long buyerId);

    Buyer findBuyerByUsername(String username);
}
