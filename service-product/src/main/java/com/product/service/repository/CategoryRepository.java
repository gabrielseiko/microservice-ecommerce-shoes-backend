package com.product.service.repository;

import com.product.service.entity.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// Busca category_name que tenga el mismo nombre
	@Query("select c from Category c where c.category_name = ?1")
	public abstract List<Category> listCategoryByNameEqual(String category_name);
	
	// Busca category_name que tenga el nombre parecido
	@Query("select c from Category c where c.category_name like ?1")
	public abstract List<Category> listCategoryByNameLike(String category_name);
	
	// Busca category_name que tenga el mismo nombre y diferente id
	@Query("select c from Category c where c.category_name = ?1  and c.id_category != ?2")
	public abstract List<Category> listCategoryByNameEqualUpdate(String category_name, int id_category);
}
