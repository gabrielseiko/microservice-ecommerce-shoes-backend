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
    
    
    @GetMapping("/listCategoryByNameLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listCategoryByNameLike(@PathVariable("var") String category_name){
		List<Category> lstSalida = null;
		if (category_name.equals("todos")) {
			lstSalida = service.list();
		}else {
			lstSalida =service.listCategoryByNameLike(category_name +  "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
    
    @GetMapping("/validateNameUpdate")
	public String validateName(@RequestParam(name = "category_name")String category_name, 
							   @RequestParam(name = "id_category")int id_category) {
		List<Category> lstSalida = service.listCategoryByNameEqualUpdate(category_name, id_category);
		if (lstSalida.isEmpty()) {
			return "{\"valid\":true}";
		} else {
			return "{\"valid\":false}";
		}
	}
}