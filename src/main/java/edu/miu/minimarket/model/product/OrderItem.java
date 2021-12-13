package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private double price;

    private double unitPrice;

    private int quantity;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "created_date")
    private LocalDate createdDate;

  /*  @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;*/
}
