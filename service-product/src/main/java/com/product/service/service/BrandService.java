package com.product.service.service;

import com.product.service.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    //metodos principales CRUD
    List<Brand> list();
    Optional<Brand> search(int id);
    Brand register(Brand obj);
    void delete(int id);
}
