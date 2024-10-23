package com.product.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.entity.Category;
import com.product.service.service.CategoryService;

@RestController
@RequestMapping("/url/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	// Listar categorias
	@GetMapping
    public ResponseEntity<List<Category>> list(){
        List<Category> response = service.list();
        return ResponseEntity.ok(response);
    }
	
    //Buscar categoria
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchCategory(@PathVariable("id") int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Category> optional = service.search(id);

        if (optional.isPresent()){
            response.put("brand", optional.get());
        } else{
            response.put("message", "Categoría no encontrada");
        }
        return ResponseEntity.ok(response);
    }
    
    //Guardar categoria
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody Category obj){
        Map<String, Object> response = new HashMap<>();
        Category objResponse = service.register(obj);

        if (objResponse != null){
            response.put("message", "Categoría registrada");
            response.put("brand", obj);
        } else {
            response.put("message", "error no se registro");
        }
        return ResponseEntity.ok(response);
    }
    
    //Actualiza categoria
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Category obj){
        Map<String, Object> response = new HashMap<>();
        Category objResponse = service.register(obj);

        if (objResponse != null){
            response.put("message", "Categoria actualizada");
            response.put("brand", obj);
        } else {
            response.put("message", "error no se actualizo");
        }
        return ResponseEntity.ok(response);
    }
    
    //Eliminar categoria
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id){
        Map<String, Object> response = new HashMap<>();
        //verificar si existe
        Optional<Category> optional = service.search(id);

        if (optional.isPresent()){
            service.delete(id);
            response.put("message", "Categoria eliminada.");
        } else {
            response.put("message", "Error");
        }
        return ResponseEntity.ok(response);
    }
	
}
