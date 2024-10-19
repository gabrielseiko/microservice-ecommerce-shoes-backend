package com.product.service.service;


import com.product.service.entity.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {

    //metodos principales CRUD
    List<Size> list();
    Optional<Size> search(int id);
    Size register(Size obj);
    void delete(int id);
}
