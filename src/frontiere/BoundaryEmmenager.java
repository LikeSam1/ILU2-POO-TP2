package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerVillageois(nomVisiteur);					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerVillageois(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int force = Clavier.entrerEntier("Quel est votre force ?");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		int forceDruide = Clavier.entrerEntier("Quel est votre force ?");
		controlEmmenager.ajouterGaulois(nomVisiteur, forceDruide);
		int effetPotionMax = Clavier.entrerEntier("Quel est la force de la potion la plus forte ?");
		int effetPotionMin = Clavier.entrerEntier("Quel est la force de la potion la plus faible ?");
		while (effetPotionMax < effetPotionMin){
			System.out.println("Attention entrée bien le Minimum et Maximum");
			effetPotionMax = Clavier.entrerEntier("Quel est la force de la potion la plus forte ?");
			effetPotionMin = Clavier.entrerEntier("Quel est la force de la potion la plus faible ?");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
