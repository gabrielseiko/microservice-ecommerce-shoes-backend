package com.user_service.service;

import com.user_service.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    //metodos principales
    List<Role> listRole();
    Optional<Role> searchRole(int id);
    Role registerRole(Role objRole);
    void deleteRole(int id);
}
