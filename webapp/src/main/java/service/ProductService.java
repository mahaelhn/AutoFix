package service;

import java.util.List;

import model.Categorie;
import model.Produit;

public interface ProductService {
	
	void getVisited(Long productId);
	
	List<Produit> getProductsByMainCategory(String mainCategoryName);
	
	List<Produit> getProductsByCategory(Categorie category);
	
	List<Produit> getAllProducts();
	
	Produit getProductById(Long productId);
	
	void save(Produit product);
	
	void delete(Long productId);
	
	List<Produit> sort(List<Produit> products, String sortType);
}
