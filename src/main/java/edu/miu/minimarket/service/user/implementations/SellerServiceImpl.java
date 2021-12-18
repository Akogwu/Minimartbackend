package edu.miu.minimarket.service.user.implementations;
import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.repository.user.RoleRepository;
import edu.miu.minimarket.repository.user.SellerRepository;
import edu.miu.minimarket.service.product.ProductService;
import edu.miu.minimarket.service.user.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;
    private ModelMapper modelMapper;
    private ProductService productService;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ProductService productService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<SellerDto> findAllSellers() {
        return sellerRepository.findAll()
                .stream().map(seller -> modelMapper.map(seller,SellerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SellerDto findSellerById(Long id) {
        return sellerRepository.findById(id).map(seller -> modelMapper.map(seller,SellerDto.class)).orElse(null);
    }

    @Override
    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public void saveSeller(Seller seller) {
        String roleSt = seller.getRoles().get(0).getName();
        seller.setRoles(new ArrayList<>());
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        log.info("Role: {}",seller );
        Role role = roleRepository.findByName(roleSt);
        sellerRepository.save(seller);
        addRoleToSeller(seller.getUsername(),role.getName());

    }

    @Override
    public void updateSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Override
    public void approveSeller(Long id) {
        sellerRepository.approveSeller(id);
    }

    @Override
    public void rejectSeller(Long id) {
        sellerRepository.rejectSeller(id);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        productDto.setSeller(productDto.getSeller());
        productService.saveProduct(productDto);
    }

    @Override
    public void addRoleToSeller(String username, String roleName) {
        Seller seller = sellerRepository.findSellerByUsername(username);
        Role role = roleRepository.findByName(roleName);
        seller.getRoles().add(role);
    }


}
