package edu.miu.minimarket.dto;


import edu.miu.minimarket.model.product.Order;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlaceOrderDto {
    private Long id;
    private Long buyerId;
    private double price;

    public PlaceOrderDto(Order order){
        this.setId(order.getId());
        this.setBuyerId(order.getBuyer().getId());
        this.setPrice(order.getTotalPrice());
    }

}
