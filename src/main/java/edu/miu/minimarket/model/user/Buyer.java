package edu.miu.minimarket.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.Product;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Buyer extends User{

    @OneToMany
    private List<Product> products;

    private boolean active = true;

    @JsonIgnore
    @OneToMany
    @JoinTable(name =  "buyer_orders")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "follow_seller")
    private List<Seller> sellers;



}
