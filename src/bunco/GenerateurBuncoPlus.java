package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.GenerateurJeuTemplate;
import generic.Jeu;

public class GenerateurBuncoPlus extends GenerateurJeuTemplate{

	@Override
	public Jeu creerJeu(int nbJoueurs) {
		CollectionDes cd = creerDes(3, 6);
		CollectionJoueurs cj = creerJoueurs(nbJoueurs);
		return new BuncoPlus(cd, cj, new BuncoPlusStrategie());
	}
}
