package edu.miu.minimarket.model.product;

import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ShoppingCart shoppingCart;

    private String status;

    @ManyToOne
    private Buyer buyer;


    private LocalDate orderDate;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shoppingCart=" + shoppingCart +
                ", status='" + status + '\'' +
                ", buyer=" + buyer +
                ", orderDate=" + orderDate +
                '}';
    }
}
