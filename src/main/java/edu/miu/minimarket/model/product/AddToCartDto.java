package edu.miu.minimarket.model.product;

import com.sun.istack.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddToCartDto {
    private Long id;

    private @NotNull
    Long productId;

    private @NotNull Long quantity;
}
