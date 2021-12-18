package edu.miu.minimarket.model.user;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    private String phone;

    @NotEmpty
    @Column(unique = true)
    private String email;

    private boolean active;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


}
