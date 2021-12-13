package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuyerDto {
    private Long id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private int point = 0;
    private boolean active;
    private Role role;

}
