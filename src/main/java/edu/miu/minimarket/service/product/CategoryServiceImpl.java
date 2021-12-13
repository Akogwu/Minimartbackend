package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Category;
import edu.miu.minimarket.repository.product.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, Category.class))
                .collect(Collectors.toList());
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> modelMapper.map(category, Category.class)).orElse(null);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(modelMapper.map(category, edu.miu.minimarket.model.product.Category.class));
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(modelMapper.map(category, edu.miu.minimarket.model.product.Category.class));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
