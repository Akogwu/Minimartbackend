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
@ToString
public class Buyer extends User{

    @OneToMany
    private List<Product> products;

    @JsonIgnore
    @OneToMany
    private List<Order> orders;
}
