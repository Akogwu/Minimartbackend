package edu.miu.minimarket.service.user;
import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.model.user.Buyer;

import java.util.List;

public interface BuyerService {
    List<BuyerDto> findAllBuyers();
    BuyerDto findBuyerById(Long id);
    void deleteBuyerById(Long id);
    void saveBuyer(BuyerDto buyerDto);
    void updateBuyer(Buyer buyer);
    void followSeller(Long buyer_id, Long sellerId);
    void unFollowSeller(Long buyer_id, Long seller_id);
}
