package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.user.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String email;
    private boolean active ;
    private Role role;

    private String businessName;

}
