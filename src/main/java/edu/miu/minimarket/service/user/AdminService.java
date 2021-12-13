package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.AdminDto;
import edu.miu.minimarket.model.user.Admin;

import java.util.List;

public interface AdminService {
    List<AdminDto> findAllAdmins();
    AdminDto findAdminById(Long id);
    void deleteAdminById(Long id);
    void saveAdmin(AdminDto adminDto);
    void updateAdmin(Admin admin);
    void approveSeller(Long id);

    void rejectSeller(Long id);

    void deleteSeller(Long id);
}
