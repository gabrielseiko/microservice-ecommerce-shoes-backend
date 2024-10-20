package com.product.service.controller;

import com.product.service.entity.Gender;
import com.product.service.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/gender")
public class GenderController {

    @Autowired
    private GenderService service;

    //LISTADO
    @GetMapping
    public ResponseEntity<List<Gender>> listGender(){
        List<Gender> respose = service.list();
        return ResponseEntity.ok(respose);
    }
    //BUSCAR
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchGender(@PathVariable("id") int idGender){
        Map<String, Object> response = new HashMap<>();
        Optional<Gender> optional = service.search(idGender);

        if (optional.isPresent()){
            response.put("gender", optional.get());
        } else {
            response.put("message", "Genero no encontrado");
        }
        return ResponseEntity.ok(response);
    }
    //REGISTRAR
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> registerGender(@RequestBody Gender objGender){
        Map<String, Object> response = new HashMap<>();
        Gender  objResponse = service.register(objGender);

        if(objResponse != null){
            response.put("message", "Genero registrado");
            response.put("Gender", objResponse);
        } else {
            response.put("message", "Error no se registro");
        }
        return ResponseEntity.ok(response);
    }
    //ACTUALIZAR
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateGender(@RequestBody Gender objGender){
        Map<String, Object> response = new HashMap<>();
        Gender objResponse = service.register(objGender);

        if (objResponse != null){
            response.put("message", "Genero actualizado");
            response.put("Gender", objResponse);
        } else {
            response.put("message", "Error no se actualizo");
        }
        return ResponseEntity.ok(response);
    }
    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteGender(@PathVariable("id") int idGender){
        Map<String, Object> response = new HashMap<>();

        //verificar si existe el genero
        Optional<Gender> optional = service.search(idGender);

        if (optional.isPresent()){
            service.delete(idGender);
            response.put("message", "Genero eliminado");
        } else {
            response.put("message", "Error no se elimino");
        }
        return ResponseEntity.ok(response);
    }
}
