package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + "je vais regarder si je peux vous trouvez une etal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Je suis désolé " + nomVendeur + " je n'ai plus d'etal disponible");
			} else {
				installerVendeur(nomVendeur);
			}	
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste une etal pour vous !");
		System.out.println("il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
		int qtnProduit = Clavier.entrerEntier("Combien de produit souhaitez vous vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, qtnProduit);
		if(numeroEtal != -1) {
			System.out.println("le vendeur " + nomVendeur + " s'est installer à l'etal n°" + numeroEtal);
		}
	}
}
