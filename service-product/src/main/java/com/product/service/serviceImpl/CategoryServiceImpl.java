package com.product.service.serviceImpl;

import com.product.service.entity.Category;
import com.product.service.repository.CategoryRepository;
import com.product.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> search(int id) {
        return repository.findById(id);
    }

    @Override
    public Category register(Category obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

	@Override
	public List<Category> listCategoryByNameLike(String category_name) {
		return repository.listCategoryByNameLike(category_name);
	}

	@Override
	public List<Category> listCategoryByNameEqual(String category_name) {
		return repository.listCategoryByNameEqual(category_name);
	}

	@Override
	public List<Category> listCategoryByNameEqualUpdate(String category_name, int id_category) {
		return repository.listCategoryByNameEqualUpdate(category_name, id_category);
	}
}
