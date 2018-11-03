package generic;

import java.util.Iterator;

/**
 *
 */
public abstract class Jeu {
	
	protected int nbTours;
	protected IStrategie strat;
    protected CollectionDes collDes;
    protected CollectionJoueurs collJoueurs;
	
	public Jeu(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie strat){
	    	this.collDes = collDes;
	    	this.collJoueurs = collJoueurs;
	    	this.strat = strat;
	}

	public void jouer() {
	    int tour = 0;
	    while (tour < nbTours) {
	        effectuerTour();
	        tour++;
        }
        calculerLeVainqueur();
    }

	public void effectuerTour(){
        Iterator<Joueur> itrJ = collJoueurs.iterator();
        while (itrJ.hasNext()) {

        }
	}

	public void calculerLeVainqueur() {
		
	}

	public void calculerScoreTour() {
		
	}
}
