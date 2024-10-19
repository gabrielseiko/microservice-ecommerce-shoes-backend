package com.product.service.controller;

import com.product.service.entity.Brand;
import com.product.service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/brand")
public class BrandController {

    @Autowired
    private BrandService service;

    //LISTAR MARCAS
    @GetMapping
    public ResponseEntity<List<Brand>> list(){
        List<Brand> response = service.list();
        return ResponseEntity.ok(response);
    }
    //BUSCAR
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchBrand(@PathVariable("id") int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Brand> optional = service.search(id);

        if (optional.isPresent()){
            response.put("brand", optional.get());
        } else{
            response.put("message", "Marca no encontrada");
        }
        return ResponseEntity.ok(response);
    }
    //REGISTAR
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody Brand obj){
        Map<String, Object> response = new HashMap<>();
        Brand objResponse = service.register(obj);

        if (objResponse != null){
            response.put("message", "Marca registrado");
            response.put("brand", obj);
        } else {
            response.put("message", "error no se registro");
        }
        return ResponseEntity.ok(response);
    }
    //ACTUALIZAR
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Brand obj){
        Map<String, Object> response = new HashMap<>();
        Brand objResponse = service.register(obj);

        if (objResponse != null){
            response.put("message", "Marca actualizado");
            response.put("brand", obj);
        } else {
            response.put("message", "error no se actualizo");
        }
        return ResponseEntity.ok(response);
    }
    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id){
        Map<String, Object> response = new HashMap<>();
        //verificar si existe
        Optional<Brand> optional = service.search(id);

        if (optional.isPresent()){
            service.delete(id);
            response.put("message", "Marca eliminado.");
        } else {
            response.put("message", "Error");
        }
        return ResponseEntity.ok(response);
    }
}
