package edu.miu.minimarket.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderItemDto {
    private double price;
    private int quantity;
    private double unitPrice;
    private Long productId;
    private Long orderId;
}
