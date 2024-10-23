package com.product.service.controller;

import com.product.service.entity.Category;
import com.product.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    //LISTADO
    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> response = service.list();
        return ResponseEntity.ok(response);
    }
    //BUSQUEDA
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchCategory(@PathVariable("id") int idCategory){
        Map<String, Object> response = new HashMap<>();
        Optional<Category> optional = service.search(idCategory);

        if (optional.isPresent()){
            response.put("category", optional.get());
        } else {
            response.put("message", "Categoria no encontrada");
        }
        return ResponseEntity.ok(response);
    }
    //REGISTRAR
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> registerCategory(@RequestBody Category objCategory){
        Map<String, Object> response = new HashMap<>();
        Category objResponse = service.register(objCategory);

        if (objResponse != null){
            response.put("message", "Categoria registrada");
            response.put("category", objResponse);
        } else{
            response.put("message", "ERROR");
        }
        return ResponseEntity.ok(response);
    }
    //ACTUALIAZR
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateCategory(@RequestBody Category objCategory){
        Map<String, Object> response = new HashMap<>();
        Category objResponse = service.register(objCategory);

        if (objResponse != null){
            response.put("message", "Categoria actualizada");
            response.put("category", objResponse);
        } else {
            response.put("message", "No se actualizo");
        }
        return ResponseEntity.ok(response);
    }
    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable("id") int idCategory){
        Map<String, Object> response = new HashMap<>();

        Optional<Category> optional = service.search(idCategory);
        if (optional.isPresent()){
            service.delete(idCategory);
            response.put("message", "Categoria eliminada");
        } else {
            response.put("message", "Error no se elimino");
        }
        return ResponseEntity.ok(response);
    }
}