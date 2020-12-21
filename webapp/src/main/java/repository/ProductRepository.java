package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Categorie;
import model.Produit;

public interface ProductRepository extends CrudRepository<Produit, Long>, PagingAndSortingRepository<Produit, Long>{
	
	List<Produit> findAllByOrderByProductViewsDesc();
	
	List<Produit> findAllByProductCategory(Categorie category);
	
}
