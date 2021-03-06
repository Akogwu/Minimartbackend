package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.user.Role;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerDto {
    private Long id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private boolean active ;
    private List<Role> roles;
    private String businessName;

}
