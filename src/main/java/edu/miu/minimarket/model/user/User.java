package edu.miu.minimarket.model.user;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    private Role role;


}
