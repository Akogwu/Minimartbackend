package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.repository.product.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream().map(product -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product,ProductDto.class)).orElse(null);
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        productRepository.save(modelMapper.map(productDto, Product.class));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        productRepository.save(modelMapper.map(productDto,Product.class));
    }


}
