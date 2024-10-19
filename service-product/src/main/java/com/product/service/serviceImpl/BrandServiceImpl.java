package com.product.service.serviceImpl;

import com.product.service.entity.Brand;
import com.product.service.repository.BrandRepository;
import com.product.service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository repository;

    @Override
    public List<Brand> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Brand> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Brand register(Brand obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
