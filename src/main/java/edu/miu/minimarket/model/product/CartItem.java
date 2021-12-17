package edu.miu.minimarket.model.product;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cartitem")
public class CartItem {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double unitPrice;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date date;


    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartItem cartItem = (CartItem) o;
        return id != null && Objects.equals(id, cartItem.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
