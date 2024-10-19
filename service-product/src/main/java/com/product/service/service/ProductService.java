package com.product.service.service;


import com.product.service.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //metodos principales CRUD
    List<Product> list();
    Optional<Product> search(int id);
    Product register(Product obj);
    void delete(int id);
}
