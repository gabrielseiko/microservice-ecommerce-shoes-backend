package com.product.service.service;

import com.product.service.entity.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {

    //metodos principales CRUD
    List<Gender> list();
    Optional<Gender> search(int id);
    Gender register(Gender obj);
    void delete(int id);
}
