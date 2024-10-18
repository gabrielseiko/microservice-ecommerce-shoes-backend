package com.user_service.controller;

import com.user_service.entity.Role;
import com.user_service.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //LISTAR ROLES
    @GetMapping
    public ResponseEntity<List<Role>> listRole(){
        List<Role> exit = roleService.listRole();
        return ResponseEntity.ok(exit);
    }
    //BUSCAR POR ID
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchRole(@PathVariable("id") int idRole){
        Map<String, Object> exit = new HashMap<>();
        Optional<Role> optionalRole = roleService.searchRole(idRole);

        if (optionalRole.isPresent()){
            exit.put("role", optionalRole.get());
        }else {
            exit.put("message", "Role no se encontro");
        }
        return ResponseEntity.ok(exit);
    }
    //REGISTRAR ROLE
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody Role objRole){
        Map<String, Object> exit = new HashMap<>();
        Role objResponse = roleService.registerRole(objRole);

        if (objResponse != null){
            exit.put("message", "Rol registrado");
            exit.put("role", objRole);
        } else {
            exit.put("message", "error no se registro");
        }
        return ResponseEntity.ok(exit);
    }
    //ACTUALIZAR
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Role objRole){
        Map<String, Object> exit = new HashMap<>();
        Role objResponse = roleService.registerRole(objRole);

        if (objResponse != null){
            exit.put("message", "Rol actualizado");
            exit.put("role", objRole);
        } else {
            exit.put("message", "error no se actualizo");
        }
        return ResponseEntity.ok(exit);
    }
    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int idRole){
        Map<String, Object> exit = new HashMap<>();

        //verificar si existe el rol
        Optional<Role> optionalRole = roleService.searchRole(idRole);

        if (optionalRole.isPresent()){
            roleService.deleteRole(idRole);
            exit.put("message", "Rol eliminado.");
        } else {
            exit.put("message", "Error");
        }
        return ResponseEntity.ok(exit);
    }
}
