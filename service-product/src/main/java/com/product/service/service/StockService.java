package com.product.service.service;

import com.product.service.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    //metodos principales CRUD
    List<Stock> list();
    Optional<Stock> search(int id);
    Stock register(Stock obj);
    void delete(int id);
}
