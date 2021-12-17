package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.user.Buyer;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CartItemDto {
    private Product product;
    private int quantity;
    private Date date;
    private double unitPrice;
    private Buyer buyer;

}
