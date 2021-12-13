package edu.miu.minimarket.model.product;

import edu.miu.minimarket.model.user.Seller;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    private double price;
    private String img;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;

}
