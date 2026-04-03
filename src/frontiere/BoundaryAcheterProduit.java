package frontiere;

import java.util.Scanner; 
import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		Scanner choix1 = new Scanner(System.in);
		
		System.out.println("1 - je veux acheter un produit.\r\n"
				+ "2 - je veux avoir une vue d'ensemble du marché.\r\n"
				+ "3 - quitter l'application. \r\n");
		
		String choixMarche = choix1.nextLine();
		
		switch (choixMarche) {
		case "1":
			System.out.println("Quel produit voulez-vous acheter ? \n");
			
			break;
		case "2": 
			System.out.println(nomAcheteur + " vous trouverez au marché : ");
			String[] marcheDonees = controlAcheterProduit.donnerEtatMarcheDonnees();
			int nbEtal = controlAcheterProduit.donnerNbEtalDonnees();
			int i = 0;
			while (i < (nbEtal * 3)) {
				System.out.println("- " + marcheDonees[i] + " qui vend " + marcheDonees[++i] + marcheDonees[++i]);
				++i;
			}
			break;
		case "3": 
			System.out.println("Au revoir client " + nomAcheteur);
			return;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choixMarche);
		}
	}
}
