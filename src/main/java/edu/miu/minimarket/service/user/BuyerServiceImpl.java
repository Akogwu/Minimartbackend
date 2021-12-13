package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.BuyerDto;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.repository.user.BuyerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService{

    private ModelMapper modelMapper;
    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(ModelMapper modelMapper, BuyerRepository buyerRepository) {
        this.modelMapper = modelMapper;
        this.buyerRepository = buyerRepository;
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
        buyerRepository.save(modelMapper.map(buyerDto, Buyer.class));
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

}
