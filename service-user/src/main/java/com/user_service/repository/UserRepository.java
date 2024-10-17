package com.user_service.repository;

import com.user_service.entity.Role;
import com.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    //Consulta para obtener los roles de un usuario específico usando la relación ManyToMany
    @Query("SELECT r FROM User u JOIN u.roles r WHERE u.id = ?1")
    List<Role> getRolesUser(int iduser);

    //ADMINISTRADOR
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 1")
    List<User> findAllAdmin();


    //TRABAJADOR
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 2")
    List<User> findAllWorker();

    //CLIENTE
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 3")
    List<User> findAllCustomer();

    //BUSQUEDA POR EMAIL
    @Query("SELECT u FROM User u WHERE u.email LIKE ?1")
    List<User> listByEmail(String username);

    //BUSQUEDA POR NOMBRE
    @Query("SELECT u FROM User u WHERE u.name LIKE ?1")
    List<User> listUserByName(String name);

    //BUSQUEDA POR APELLIDO
    @Query("SELECT u FROM User u WHERE u.lastName LIKE ?1")
    List<User> listUserByLastName(String lastname);

    //BUSQUEDA POR DNI
    @Query("SELECT u FROM User u WHERE u.dni LIKE ?1")
    List<User> listByDni(String dni);

}
