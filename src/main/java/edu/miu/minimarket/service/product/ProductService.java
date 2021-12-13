package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();
    ProductDto findProductById(Long id);
    void saveProduct(ProductDto productDto);
    void deleteProductById(Long id);
    void updateProduct(ProductDto productDto);

}
