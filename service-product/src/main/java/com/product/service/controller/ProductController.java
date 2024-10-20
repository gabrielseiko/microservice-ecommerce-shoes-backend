package com.product.service.controller;

import com.product.service.entity.Product;
import com.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/product")
public class ProductController {

    @Autowired
    private ProductService service;

    //LISTADO
    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> response = service.list();
        return ResponseEntity.ok(response);
    }
    //BUSCAR
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchProduct(@PathVariable("id") int idProduct){
        Map<String, Object> response = new HashMap<>();
        Optional<Product> optional = service.search(idProduct);

        if (optional.isPresent()){
            response.put("product", optional.get());
        } else {
            response.put("message", "Producto no encontrado");
        }
        return ResponseEntity.ok(response);
    }
    //REGISTRAR
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> registerProduct(@RequestBody Product obj){
        Map<String, Object> response = new HashMap<>();
        Product objResponse = service.register(obj);

        if (objResponse != null){
            response.put("message", "Producto registrado");
            response.put("product", obj);
        } else {
            response.put("message", "Error no se registro");
        }
        return ResponseEntity.ok(response);
    }
    //ACTUALIZAR
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateProduct(@RequestBody Product obj){
        Map<String, Object> response = new HashMap<>();
        Product objResponse = service.register(obj);

        if(objResponse != null) {
            response.put("message", "Producto Actualizado");
            response.put("Producto", obj);
        } else {
            response.put("message", "Error no se actualizo");
        }
        return ResponseEntity.ok(response);
    }
    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable("id") int idProduct){
        Map<String, Object> response = new HashMap<>();
        //verificar si existe
        Optional<Product> optional = service.search(idProduct);

        if (optional.isPresent()){
            service.delete(idProduct);
            response.put("message", "Producto eliminado");
        }else {
            response.put("message", "Error");
        }
        return ResponseEntity.ok(response);
    }
}
