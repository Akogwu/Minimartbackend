package edu.miu.minimarket.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlaceOrderDto implements Serializable{
    private Long id = 1L;
    private Long buyerId;
    private double price;
    private List<Object> items;

    public PlaceOrderDto(Long buyerId, double price, List<Object> items){
        this.setBuyerId(buyerId);
        this.setPrice(price);
        this.setItems(items);
    }

}
