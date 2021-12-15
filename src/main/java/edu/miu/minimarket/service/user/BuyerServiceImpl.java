package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.repository.user.BuyerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService{

    private ModelMapper modelMapper;
    private BuyerRepository buyerRepository;
    private SellerService sellerService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public BuyerServiceImpl(ModelMapper modelMapper, BuyerRepository buyerRepository, SellerService sellerService, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.buyerRepository = buyerRepository;
        this.sellerService = sellerService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<BuyerDto> findAllBuyers() {
        return buyerRepository.findAll().stream().map(buyer -> modelMapper.map(buyer,BuyerDto.class)).collect(Collectors.toList());
    }

    @Override
    public BuyerDto findBuyerById(Long id) {
        return buyerRepository.findById(id).map(buyer -> modelMapper.map(buyer, BuyerDto.class)).orElse(null);
    }

    @Override
    public void deleteBuyerById(Long id) {
        buyerRepository.deleteById(id);
    }

    @Override
    public void saveBuyer(BuyerDto buyerDto) {
        Buyer buyer = modelMapper.map(buyerDto,Buyer.class);
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        buyerRepository.save(buyer);
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }


    @Override
    public void followSeller(Long buyer_id, Long seller_id) {
        Buyer buyer = buyerRepository.findById(buyer_id).orElse(null);
        Seller seller = modelMapper.map(sellerService.findSellerById(seller_id),Seller.class);
        assert buyer != null;
        List<Seller> followedByThisBuyer = buyerRepository.findSellersFollowedByThisBuyer(buyer_id);
        followedByThisBuyer.add(seller);
        buyer.setSellers(followedByThisBuyer);
    }

    @Override
    public void unFollowSeller(Long buyer_id, Long seller_id) {
        Buyer buyer = buyerRepository.findById(buyer_id).orElse(null);
        assert buyer != null;
        List<Seller> followedByThisBuyer = buyerRepository.findSellersFollowedByThisBuyer(buyer_id);
        List<Seller> removeSellerWithThisId = followedByThisBuyer.stream()
                .filter(_seller -> !Objects.equals(_seller.getId(), seller_id)).toList();
        buyer.setSellers(removeSellerWithThisId);
    }


}
