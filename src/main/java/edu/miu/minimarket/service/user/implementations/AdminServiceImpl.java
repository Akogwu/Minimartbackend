package edu.miu.minimarket.service.user.implementations;

import edu.miu.minimarket.dto.AdminDto;
import edu.miu.minimarket.model.user.Admin;
import edu.miu.minimarket.repository.user.AdminRepository;
import edu.miu.minimarket.service.user.AdminService;
import edu.miu.minimarket.service.user.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private ModelMapper modelMapper;
    private SellerService sellerService;

    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper, SellerService sellerService) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
        this.sellerService = sellerService;
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        return adminRepository.findAll()
                .stream().map(admin -> modelMapper.map(admin,AdminDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto findAdminById(Long id) {
        return adminRepository.findById(id)
                .map(admin -> modelMapper.map(admin,AdminDto.class)).orElse(null);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void saveAdmin(AdminDto adminDto) {
        adminRepository.save(modelMapper.map(adminDto,Admin.class));
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.save(admin);
    }


    @Override
    public void approveSeller(Long id) {
        sellerService.approveSeller(id);
    }

    @Override
    public void rejectSeller(Long id) {
        sellerService.rejectSeller(id);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerService.deleteSellerById(id);
    }

}
