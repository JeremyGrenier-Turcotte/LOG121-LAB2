package bunco;

import generic.De;
import generic.IStrategie;
import generic.Jeu;

import java.util.Iterator;

public class BuncoPlusStrategie implements IStrategie {

	@Override
	public void calculerLeVainqueur(Jeu jeu) {
		// TODO Auto-generated method stub

	}

    /**
     * Calcule le score pour un joueur durant un tour
     * @param jeu jeu
     * @return score
     */
	@Override
	public int calculerScoreTour(Jeu jeu) {

	    // Premierement on récupere le tour courant et on brasse les dés
	    int tourCourant = ((BuncoPlus)jeu).getTourCourant();
		jeu.getCollDes().brasserDes();

		// On itère dans la collection de dés pour savoir combien de dés correspondent au tour courant.
        int nbDesEquivalantAuTour = 0;
        Iterator<De> itrDes = jeu.getCollDes().iterator();
        while (itrDes.hasNext()) {
            De de = itrDes.next();
            // Quand la valeur du dé brassé équivaut au tour courant, on incrémente
            if(de.getValeur() == tourCourant) {
                nbDesEquivalantAuTour++;
            }
        }

        // Si nous avons 3 dés qui correspondent au tour courant, nous avons un bunco!
        return nbDesEquivalantAuTour == 3 ? 21 : nbDesEquivalantAuTour;
	}

}
