package service;

import java.util.List;

import model.Categorie;

public interface CategoryService {
	
	List<Categorie> getAllCategory();
	
	List<String> getAllMainCategory();

	List<String> getAllSubCategory();
	
	void save(Categorie category);
	
	void delete(Long categoryId);
	
	Categorie  getCategoryById(Long categoryId);
}
