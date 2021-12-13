package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.product.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String img;
    private Category category;

    public  void assignCategoryToProduct(Category category){
        this.category = category;
    }
}
