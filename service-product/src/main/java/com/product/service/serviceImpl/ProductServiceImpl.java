package com.product.service.serviceImpl;

import com.product.service.entity.Product;
import com.product.service.repository.ProductRepository;
import com.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Product register(Product obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
