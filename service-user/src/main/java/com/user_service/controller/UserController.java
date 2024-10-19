package com.user_service.controller;

import com.user_service.entity.Role;
import com.user_service.entity.User;
import com.user_service.service.RoleService;
import com.user_service.service.UserService;
import com.user_service.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/user")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //LISTAR TODOS LOS USUARIOS
    @GetMapping
    public ResponseEntity<List<User>> listUser(){
        List<User> exit = userService.listUsers();
        return ResponseEntity.ok(exit);
    }
    //LISTAR ADMINS
    @GetMapping("/admin")
    public ResponseEntity<List<User>> listAllAdmin(){
        List<User> admin = userService.findByAllAdmin();
        return ResponseEntity.ok(admin);
    }
    //LISTAR WORKERS
    @GetMapping("/worker")
    public ResponseEntity<List<User>> listAllWorker(){
        List<User> worker = userService.findByAllWorker();
        return ResponseEntity.ok(worker);
    }
    //LISTAR CUSTOMERS
    @GetMapping("/customer")
    private ResponseEntity<List<User>> listAllCustomer(){
        List<User> customer = userService.finByAllCustomer();
        return ResponseEntity.ok(customer);
    }
    //BUSCAR POR ID
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchUser(@PathVariable("id") int idUser){
        Map<String, Object> exit = new HashMap<>();
        Optional<User> optionalUser = userService.searchUser(idUser);

        if (optionalUser.isPresent()) {
            exit.put("user", optionalUser.get());
        } else {
            exit.put("message", "User not found");
        }
        return ResponseEntity.ok(exit);
    }
    //REGISTRAR USUARIO
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody User objUser){
        Map<String, Object> exit = new HashMap<>();
        User objExit = userService.registerUser(objUser);

        if (objExit != null){
            exit.put("message", "Usuario registrado" );
            exit.put("user", objExit);
        } else {
            exit.put("message", "error no se registro");
        }

        return ResponseEntity.ok(exit);
    }
    //REGISTRAR WORKER
    @PostMapping("/register/worker")
    @ResponseBody
    public ResponseEntity<?> registerWorker(@RequestBody User objUser){
        Map<String, Object> response = new HashMap<>();
        Optional<Role> optionalRole = roleService.searchRole(2); //buscar

        if (optionalRole.isPresent()){
            Role role = optionalRole.get();
            objUser.setRoles(List.of(role)); // asignar rol
            User objResponse = userService.registerUser(objUser);
            if (objResponse != null){
                response.put("message", "Trabajador registrado" );
                response.put("user", objResponse);
            } else {
                response.put("message", "error no se registro");
            }
        }
        return ResponseEntity.ok(response);
    }
    //REGISTRAR WORKER
    @PostMapping("/register/customer")
    @ResponseBody
    public ResponseEntity<?> registerCustomer(@RequestBody User objUser){
        Map<String, Object> response = new HashMap<>();
        Optional<Role> optionalRole = roleService.searchRole(3); //buscar

        if (optionalRole.isPresent()){
            Role role = optionalRole.get();
            objUser.setRoles(List.of(role)); // asignar rol
            User objResponse = userService.registerUser(objUser);
            if (objResponse != null){
                response.put("message", "Cliente registrado" );
                response.put("user", objResponse);
            } else {
                response.put("message", "error no se registro");
            }
        }
        return ResponseEntity.ok(response);
    }
    //ACTUALIZAR USUARIO
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> update(@RequestBody User objUser){
        Map<String, Object> exit = new HashMap<>();
        User objExit = userService.registerUser(objUser);

        if (objExit != null){
            exit.put("message", "Usuario actualizado" );
            exit.put("user", objExit);
        } else {
            exit.put("message", "error no se actualizo");
        }

        return ResponseEntity.ok(exit);
    }
    //ELIMINAR USUARIO
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int idUser) {
        Map<String, Object> exit = new HashMap<>();

        // Verificar si el usuario existe
        Optional<User> optionalUser = userService.searchUser(idUser);

        if (optionalUser.isPresent()) {
            // Si el usuario existe, lo eliminamos
            userService.deleteUser(idUser);
            exit.put("message", "Usuario eliminado con éxito");
        } else {
            // Si el usuario no existe, enviamos un mensaje de error
            exit.put("message", "Error: Usuario no encontrado");
        }

        return ResponseEntity.ok(exit);
    }
}
