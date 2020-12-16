package auto.user.metier;

import auto.user.entites.Produit;

public interface AdminProduitMetier extends InternauteMetier {
	public Long ajouterProduit(Produit  p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p); 
}