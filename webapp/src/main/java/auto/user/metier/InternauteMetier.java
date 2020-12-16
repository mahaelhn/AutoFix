package auto.user.metier;


import java.util.LinkedList;


import auto.user.entites.Categorie;
import auto.user.entites.Client;
import auto.user.entites.Commande;
import auto.user.entites.Panier;
import auto.user.entites.Produit;


public interface InternauteMetier {
	
	public LinkedList <Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public LinkedList<Produit> listproduits();
	public LinkedList<Produit>produitsParMotCle(String mc);
	public LinkedList<Produit>produitsParCategorie(Long idCat);
	public LinkedList<Produit>produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p,Client c);

} 