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

	    // Premierement on récupere le tour courant
	    int tourCourant = jeu.getTourCourant();
		int nbDesEquivalantAuTour = 0;

		// On itère dans la collection de dés pour savoir combien de dés correspondent au tour courant.
        Iterator<De> itrDes = jeu.getCollDes().iterator();
        while (itrDes.hasNext()) {
            De de = itrDes.next();
            // Quand la valeur du dé brassé équivaut au tour courant, on incrémente
            if(de.getValeur() == tourCourant) {
                nbDesEquivalantAuTour++;
            }
        }

        // Si nous avons 3 dés qui correspondent au tour courant, nous avons un bunco!
        int score = nbDesEquivalantAuTour == 3 ? 21 : nbDesEquivalantAuTour;
        
        if(nbDesEquivalantAuTour == 0 && bunco5Pts(jeu))
        	score = 5;
        
        if(score == 0 || score == 21) {
            jeu.setPeutPasserAuSuivant(true);
        } else {
            jeu.setPeutPasserAuSuivant(false);
        }
        return score;
	}

	private boolean bunco5Pts(Jeu jeu) {
		// On itère dans la collection de dés pour savoir combien de dés correspondent au tour courant.
        Iterator<De> itrDes = jeu.getCollDes().iterator();
        int valeur = 0;
        if(itrDes.hasNext()) {
        	valeur = itrDes.next().getValeur();
        }
        while (itrDes.hasNext()) {
            De de = itrDes.next();
            // Quand la valeur du dé brassé équivaut au tour courant, on incrémente
            if(de.getValeur() != valeur) {
            	return false;
            }
        }
        return true;
	}

}
