package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.De;
import generic.GenerateurJeuTemplate;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

public class GenerateurBuncoPlus extends GenerateurJeuTemplate{

	public GenerateurBuncoPlus(int nbJoueurs) {
		super(nbJoueurs);
	}



	private static final int NB_DES = 3;
	private static final int NB_FACES = 6;


	@Override
	public CollectionDes creerDes() {
		CollectionDes cd = new CollectionDes();
		for(int i =0; i < NB_DES; i ++) {
		    cd.ajouterDe(new De(NB_FACES));
        }
        return cd;
	}


	@Override
	public CollectionJoueurs creerJoueurs() {
	    CollectionJoueurs cj = new CollectionJoueurs();
		for(int i =0; i < nbJoueurs; i++) {
		    cj.ajouterJoueur(new Joueur(i+1));
        }
        return cj;
	}


	@Override
	public IStrategie creerStrategie() {
		return new BuncoPlusStrategie();
	}


	@Override
	public Jeu creerJeu(CollectionDes cd, CollectionJoueurs cj, IStrategie strategie) {
		return new BuncoPlus(cd, cj, strategie);
	}
}
