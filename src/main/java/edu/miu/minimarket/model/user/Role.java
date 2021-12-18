package edu.miu.minimarket.model.user;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = AUTO)
    private Long id;
   private String name;

}
