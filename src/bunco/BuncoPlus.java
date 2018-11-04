package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

public class BuncoPlus extends Jeu{

	private int tourCourant = 1;

	public BuncoPlus(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie strat) {
		super(collDes, collJoueurs, strat);
	}

	public int getTourCourant() {
	    return tourCourant;
    }

	@Override
    public void effectuerTour() {
	    super.effectuerTour();
	    tourCourant++;
    }

    @Override
    public void calculerScoreTour() {
		int score = strat.calculerScoreTour(this);
		if(score > 0 && score < 21) {
		    joueurCourant.ajouterAuScore(score);
		    calculerScoreTour();
        } else if(score == 21) {
		    joueurCourant.ajouterAuScore(score);
        }
    }
}
