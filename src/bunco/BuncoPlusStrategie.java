package bunco;

import generic.De;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

import java.util.Iterator;

public class BuncoPlusStrategie implements IStrategie {

	@Override
	public Joueur[] calculerLeVainqueur(Jeu jeu) {

	    int nbJoueurs = jeu.getCollJoueurs().getNbJoueurs();
		Joueur[] array = new Joueur[nbJoueurs];
		Iterator<Joueur> itrJ = jeu.getCollJoueurs().iterator();

		// Premierement mettre les joueurs dans un tableau
		int index = 0;
		while (itrJ.hasNext()) {
		    array[index++] = itrJ.next();
        }

        // Tri à bulles sur le tableau
        boolean isSorted = false;
		while (!isSorted) {
		    isSorted = true;
		    for (int i =0; i < nbJoueurs-1; i++) {
		        if(array[i].compareTo(array[i+1]) == -1) {
		            Joueur temp = array[i+1];
		            array[i+1] = array[i];
		            array[i] = temp;
		            isSorted = false;
                }
            }
            nbJoueurs--;
        }

        return array;
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
