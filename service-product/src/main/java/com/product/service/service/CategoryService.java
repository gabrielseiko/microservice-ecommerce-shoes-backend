package com.product.service.service;

import com.product.service.entity.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

public interface CategoryService {

    //Métodos para el CRUD
    List<Category> list();
    Optional<Category> search(int id);
    Category register(Category obj);
    void delete(int id);
    
    public abstract List<Category> listCategoryByNameLike(String category_name);
    
    //Métodos para validaciones
    public abstract List<Category> listCategoryByNameEqual(String category_name);
	public abstract List<Category> listCategoryByNameEqualUpdate(String category_name, int id_category);
    
}
