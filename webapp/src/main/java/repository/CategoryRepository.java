package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Categorie;

public interface CategoryRepository extends CrudRepository<Categorie, Long>{
	
	List<Categorie> findAllByMainCategoryName(String mainCategoryName);
	
	List<Categorie> findAllBySubCategoryName(String subCategoryName);
	
	@Query(value = "SELECT DISTINCT sub_category_name from category" , nativeQuery = true)
	List<String> findAllSubCategoryName();
	
	@Query(value = "SELECT DISTINCT main_category_name from category" , nativeQuery = true)
	List<String> findAllMainCategoryName();
}
