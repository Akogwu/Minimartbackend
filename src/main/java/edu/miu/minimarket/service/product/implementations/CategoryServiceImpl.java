package edu.miu.minimarket.service.product.implementations;

import edu.miu.minimarket.repository.product.Category;
import edu.miu.minimarket.service.product.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private Category categoryRepository;
    private ModelMapper modelMapper;


    @Autowired
    public CategoryServiceImpl(Category categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<edu.miu.minimarket.model.product.Category> findAllCategory() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, edu.miu.minimarket.model.product.Category.class))
                .collect(Collectors.toList());
    }

    @Override
    public edu.miu.minimarket.model.product.Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> modelMapper.map(category, edu.miu.minimarket.model.product.Category.class)).orElse(null);
    }

    @Override
    public void saveCategory(edu.miu.minimarket.model.product.Category category) {
        categoryRepository.save(modelMapper.map(category, edu.miu.minimarket.model.product.Category.class));
    }

    @Override
    public void updateCategory(edu.miu.minimarket.model.product.Category category) {
        categoryRepository.save(modelMapper.map(category, edu.miu.minimarket.model.product.Category.class));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
