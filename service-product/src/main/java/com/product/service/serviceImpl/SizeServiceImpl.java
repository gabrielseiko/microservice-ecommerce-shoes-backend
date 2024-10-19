package com.product.service.serviceImpl;

import com.product.service.entity.Size;
import com.product.service.repository.SizeRepository;
import com.product.service.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository repository;

    @Override
    public List<Size> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Size> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Size register(Size obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
