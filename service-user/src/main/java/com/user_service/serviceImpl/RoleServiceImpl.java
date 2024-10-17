package com.user_service.serviceImpl;

import com.user_service.entity.Role;
import com.user_service.repository.RoleRepository;
import com.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;

    @Override
    public List<Role> listRole() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> searchRole(int id) {
        return repository.findById(id);
    }

    @Override
    public Role registerRole(Role objRole) {
        return repository.save(objRole);
    }

    @Override
    public void deleteRole(int id) {
        repository.deleteById(id);
    }
}
