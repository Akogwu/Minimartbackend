package edu.miu.minimarket.repository.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Category extends CrudRepository<edu.miu.minimarket.model.product.Category, Long> {
    List<edu.miu.minimarket.model.product.Category> findAll();
}
