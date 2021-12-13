package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.minimarket.model.user.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JsonIgnore
    @OneToOne(targetEntity = Buyer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "buyer_id")
    private Buyer buyer;

    private int quantity;
}
