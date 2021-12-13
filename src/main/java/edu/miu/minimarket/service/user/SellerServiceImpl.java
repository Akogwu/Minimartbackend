package edu.miu.minimarket.service.user;
import edu.miu.minimarket.dto.SellerDto;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.repository.user.SellerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{

    private SellerRepository sellerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
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
    public void saveSeller(SellerDto sellerDto) {
        sellerRepository.save(modelMapper.map(sellerDto,Seller.class));
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


}
