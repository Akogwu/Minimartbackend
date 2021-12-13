package edu.miu.minimarket.dto;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.user.Buyer;


public class CartDto {
    private Product product;
    private Buyer buyer;
    private int quantity;
}
