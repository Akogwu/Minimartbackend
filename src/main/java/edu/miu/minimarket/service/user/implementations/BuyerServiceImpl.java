package edu.miu.minimarket.service.user.implementations;

import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.model.product.CartItem;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.repository.product.CartItemRepository;
import edu.miu.minimarket.repository.user.BuyerRepository;
import edu.miu.minimarket.repository.user.RoleRepository;
import edu.miu.minimarket.service.product.OrderService;
import edu.miu.minimarket.service.user.BuyerService;
import edu.miu.minimarket.service.user.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    private ModelMapper modelMapper;
    private BuyerRepository buyerRepository;
    private SellerService sellerService;
    private PasswordEncoder passwordEncoder;
    private CartItemRepository cartItemRepository;
    private OrderService orderService;
    private RoleRepository roleRepository;




    @Autowired
    public BuyerServiceImpl(ModelMapper modelMapper,
                            BuyerRepository buyerRepository,
                            SellerService sellerService,
                            PasswordEncoder passwordEncoder,
                            CartItemRepository cartItemRepository,
                            OrderService orderService, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.buyerRepository = buyerRepository;
        this.sellerService = sellerService;
        this.passwordEncoder = passwordEncoder;
        this.cartItemRepository = cartItemRepository;
        this.orderService = orderService;
        this.roleRepository = roleRepository;
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
    public void saveBuyer(Buyer buyer) {
        String roleStr = buyer.getRoles().get(0).getName();
        buyer.setRoles(new ArrayList<>());;
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        buyerRepository.save(buyer);
        addRoleToBuyer(buyer.getUsername(),roleStr);
    }

    public void addRoleToBuyer(String username, String roleName) {
        Buyer buyer = buyerRepository.findBuyerByUsername(username);
        Role role = roleRepository.findByName(roleName);
        buyer.getRoles().add(role);
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
                .filter(_seller -> !Objects.equals(_seller.getId(), seller_id))
                .collect(Collectors.toList());
        buyer.setSellers(removeSellerWithThisId);
    }

    @Override
    public void updateThisShoppingCart(Long buyerId, Long cartItemId, int quantity) {
        Buyer buyer = buyerRepository.findById(buyerId).orElse(null);
        if (buyer != null){
            CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
            assert cartItem != null;
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public void placeNewOrder(Order order) {
        System.out.println(order);
        try {
            orderService.saveOrder(order);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }




}
