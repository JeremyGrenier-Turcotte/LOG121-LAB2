package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.IStrategie;
import generic.Jeu;

public class BuncoPlus extends Jeu{

	public BuncoPlus(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie strat) {
		super(collDes, collJoueurs, strat);
		nbTours = 6;
	}

	@Override
    public void calculerScoreTour() {
        collDes.brasserDes();
        int score = strat.calculerScoreTour(this);
        joueurCourant.ajouterAuScore(score);

        if(score == 0 || score == 21) {
            peutPasserAuSuivant = true;
        } else {
            peutPasserAuSuivant = false;
        }
    }
}
