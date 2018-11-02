package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

public class BuncoPlus extends Jeu{
	
	Joueur joueurCourant;
	int tourCourant; /* =1*/

	public BuncoPlus(CollectionDes collDes, CollectionJoueurs collJoueurs,
			IStrategie strat) {
		super(collDes, collJoueurs, strat);
		// TODO Auto-generated constructor stub
	}

}
