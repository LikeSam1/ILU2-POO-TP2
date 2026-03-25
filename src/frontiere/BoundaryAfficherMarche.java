package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfoMarcher();
		if(infoMarche.length == 0) {
			System.out.println("Le Marché est vide, revenez plus tard.");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché");
			for (int i = 0; i < infoMarche.length; i++) {
				System.out.println("- " + infoMarche[i] + "qui vend " + infoMarche[i++] + " " + infoMarche[i++]);
			}
		}
		
	}
}
