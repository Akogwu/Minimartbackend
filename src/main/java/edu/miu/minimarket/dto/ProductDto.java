package edu.miu.minimarket.dto;

import edu.miu.minimarket.model.product.Category;
import edu.miu.minimarket.model.user.Seller;
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
    private String image;
    private int quantity;
    private Long cat_id;
    private Category category;
    private Seller seller;


    public  void assignCategoryToProduct(Category category){
        this.category = category;
    }
}
