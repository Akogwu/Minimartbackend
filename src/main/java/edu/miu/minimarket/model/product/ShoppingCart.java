package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.minimarket.model.user.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shoppingcart")
public class ShoppingCart {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Transient
    private Double totalPrice;

    @Transient
    private double itemsSize;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();

    public Double getTotalPrice() {
        return items.stream().map(CartItem::getProduct).map(Product::getPrice)
                .reduce(0.0,(a,b)-> a);
    }

    public double getItemsSize() {
        return this.items.size();
    }

    //    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;

    private String sessionToken;

    @JsonIgnore
    @OneToOne(targetEntity = Buyer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "buyer_id")
    private Buyer buyer;

}
