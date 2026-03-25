package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Etal etal = controlLibererEtal.isVendeur(nomVendeur);
		if(etal == null) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.parseBoolean(donneesEtal[0])) {
				System.out.println("Vous avez vendu" + donneesEtal[4] + "sur" + donneesEtal[3] + " " + donneesEtal[2] + ".");
				System.out.println("En revoir" + nomVendeur + ", passez une bonne journée");
			}
		}
	}

}
