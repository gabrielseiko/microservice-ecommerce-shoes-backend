package com.user_service.service;

import com.user_service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //metodos principales
    public abstract List<User> listUsers();
    public abstract Optional<User> searchUser(int id_user);
    public abstract User registerUser(User objUser);
    public abstract void deleteUser(int id_user);
    //Listar admin, trabajador, cliente
    public abstract List<User> findByAllAdmin();
    public abstract List<User> findByAllWorker();
    public abstract List<User> finByAllCustomer();
    //Buscar por parametros
    public abstract List<User> finByEmail(String email);
    public abstract List<User> findByName(String name);
    public abstract List<User> findByLastName(String lastname);
    public abstract List<User> finByDni(String dni);

}
