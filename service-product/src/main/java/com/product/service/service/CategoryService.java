package com.product.service.service;

import com.product.service.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    //metodos principales CRUD
    List<Category> list();
    Optional<Category> search(int id);
    Category register(Category obj);
    void delete(int id);
}
