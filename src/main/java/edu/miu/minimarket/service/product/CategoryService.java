package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Category;

import java.util.List;

public interface CategoryService {


    List<Category> findAllCategory();
    Category findCategoryById(Long id);
    void saveCategory(Category category);
    void updateCategory(Category category);
    void deleteCategoryById(Long id);

}
