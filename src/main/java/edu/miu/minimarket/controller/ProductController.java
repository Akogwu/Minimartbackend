package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.model.product.Category;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.service.product.CategoryService;
import edu.miu.minimarket.service.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, ModelMapper modelMapper) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ProductDto getSingleProduct(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }



}
