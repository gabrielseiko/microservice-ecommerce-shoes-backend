package com.product.service.serviceImpl;

import com.product.service.entity.Gender;
import com.product.service.repository.GenderRepository;
import com.product.service.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository repository;

    @Override
    public List<Gender> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Gender> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Gender register(Gender obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
