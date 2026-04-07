package frontiere;

import java.util.Scanner; 
import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
 
		int choixUtilisateur = 0;
		do {
			StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append("2 - je veux avoir une vue d'ensemble du marché.\n");
			question.append("3 - quitter l'application.");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
 
			switch (choixUtilisateur) {
			case 1:
				acheterUnProduit(nomAcheteur);
				break;
			case 2:
				afficherMarche(nomAcheteur);
				break;
			case 3:
				System.out.println("Au revoir client " + nomAcheteur);
				break;
			default:
				System.out.println("Vous devez entrer un chiffre entre 1 et 3");
				break;
			}
			System.out.println();
		} while (choixUtilisateur != 3);
	}
	
	private void acheterUnProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
 
		Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
 
		if (vendeurs == null || vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}
 
		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i].getNom());
		}
 
		int choixVendeur = Clavier.entrerEntier("") - 1;
		if (choixVendeur < 0 || choixVendeur >= vendeurs.length) {
			System.out.println("Choix invalide.");
			return;
		}
 
		String nomVendeur = vendeurs[choixVendeur].getNom();
 
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		System.out.println("Bonjour " + nomAcheteur);
 
		int quantiteSouhaitee = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
 
		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantiteSouhaitee);
 
		if (quantiteAchetee == -1) {
			System.out.println("Je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else if (quantiteAchetee == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee
					+ " " + produit + ", malheureusement il n'y en a plus !");
		} else if (quantiteAchetee < quantiteSouhaitee) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee
					+ " " + produit + ", malheureusement " + nomVendeur
					+ " n'en a plus que " + quantiteAchetee + ". "
					+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteAchetee
					+ " " + produit + " à " + nomVendeur);
		}
	}
 
	private void afficherMarche(String nomAcheteur) {
		String[] marcheDonnees = controlAcheterProduit.donnerEtatMarcheDonnees();
		int nbEtal = marcheDonnees.length / 3;
 
		if (nbEtal == 0) {
			System.out.println(nomAcheteur + ", le marché est vide pour l'instant.");
			return;
		}
 
		System.out.println(nomAcheteur + ", vous trouverez au marché :");
		for (int i = 0; i < nbEtal; i++) {
			String nomVendeur  = marcheDonnees[i * 3];
			String quantite    = marcheDonnees[i * 3 + 1];
			String typeProduit = marcheDonnees[i * 3 + 2];
			System.out.println("- " + nomVendeur + " qui vend " + quantite + " " + typeProduit);
		}
	}
}
