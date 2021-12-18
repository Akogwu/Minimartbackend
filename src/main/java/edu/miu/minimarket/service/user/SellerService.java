package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Seller;

import java.util.List;

public interface SellerService {

    List<SellerDto> findAllSellers();
    SellerDto findSellerById(Long id);
    void deleteSellerById(Long id);
    void saveSeller(Seller seller);
    void updateSeller(Seller seller);
    void approveSeller(Long id);
    void rejectSeller(Long id);
    void addProduct(ProductDto productDto);
    void addRoleToSeller(String username, String roleName);
}
