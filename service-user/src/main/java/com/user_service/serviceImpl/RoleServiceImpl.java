package com.user_service.serviceImpl;

import com.user_service.entity.Role;
import com.user_service.repository.RoleRepository;
import com.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> listRole() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> searchRole(int idRole) {
        return repository.findById(idRole);
    }

    @Override
    public Role registerRole(Role objRole) {
        return repository.save(objRole);
    }

    @Override
    public void deleteRole(int idRole) {
        repository.deleteById(idRole);
    }
}
