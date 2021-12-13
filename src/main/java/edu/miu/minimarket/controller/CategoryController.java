package edu.miu.minimarket.controller;
import edu.miu.minimarket.model.product.Category;
import edu.miu.minimarket.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService  categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public Category getSingleCategory(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }


    @PostMapping
    public void createCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }



}
