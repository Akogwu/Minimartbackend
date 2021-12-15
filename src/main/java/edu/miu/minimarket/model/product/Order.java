package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.minimarket.model.user.Buyer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDate createdDate;
    private String orderStatus;
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Buyer.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Buyer buyer;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;



}
