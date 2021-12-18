package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.product.ShoppingCart;
import edu.miu.minimarket.model.user.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {
    private Long id;
    private ShoppingCart shoppingCart;
    private Buyer buyer;

    private String status;

    @Nullable
    private LocalDate orderDate;
}
