package edu.miu.minimarket.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.minimarket.model.product.Product;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Seller extends User {
    @Nullable
    private String businessName;


    @JsonIgnore
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Product> products;
}
