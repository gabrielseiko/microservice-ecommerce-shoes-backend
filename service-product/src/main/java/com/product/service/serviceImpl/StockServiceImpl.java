package com.product.service.serviceImpl;

import com.product.service.entity.Stock;
import com.product.service.repository.StockRepository;
import com.product.service.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;

    @Override
    public List<Stock> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Stock> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Stock register(Stock obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
