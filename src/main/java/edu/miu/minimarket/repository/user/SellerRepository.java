package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Seller;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
    List<Seller> findAll();

    @Modifying
    @Query("update Seller s set s.active = true where s.id =:id")
    void approveSeller(Long id);

    @Modifying
    @Query("update Seller s set s.active = false where s.id =:id")
    void rejectSeller(Long id);
}
