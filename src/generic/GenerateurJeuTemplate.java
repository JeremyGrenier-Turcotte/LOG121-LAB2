package generic;

public abstract class GenerateurJeuTemplate {
	
	public abstract Jeu creerJeu(int nbJoueurs);

	public static CollectionJoueurs creerJoueurs(int nbJoueurs) {
	    CollectionJoueurs cj = new CollectionJoueurs();
		for(int i =0; i < nbJoueurs; i++) {
		    cj.ajouterJoueur(new Joueur(i+1));
        }
        return cj;
	}

	public static CollectionDes creerDes(int nbDes, int nbFaces) {
		CollectionDes cd = new CollectionDes();
		for(int i =0; i < nbDes; i ++) {
		    cd.ajouterDe(new De(nbFaces));
        }
        return cd;
	}
}
