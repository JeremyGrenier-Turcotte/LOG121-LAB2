package bunco;

import generic.De;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

import java.util.Iterator;

/**
 * Classe qui sert à compter le nombre de points d'un joueur pour une main et à calculer le vainqueur.
 */
public class BuncoPlusStrategie implements IStrategie {


    /**
     * Trie les joueurs participant à un jeu selon leur score en ordre décroissant
     * @param jeu jeu
     * @return tableau de joueurs triés selon leur pointage.
     */
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
        if(nbDesEquivalantAuTour == 3) {
            return 21;
        } else if(nbDesEquivalantAuTour == 0) {
            return estUnnbunco5Pts(jeu.getCollDes().iterator()) ? 5 : 0;
        }
        return nbDesEquivalantAuTour;
	}

    /**
     * Détermine si un itérateur de dés contient 3 dés identiques susceptibles de créer un bunco 5 points.
     * @param itrDes itérateur de dés
     * @return vrai si on a 3 dés identiques, faux sinon.
     */
	private boolean estUnnbunco5Pts(Iterator<De> itrDes) {
		// Itération dans la collection pour savoir si les dés ont tous la même valeur.
        De dernierDe = null;
        while(itrDes.hasNext()) {
            if(dernierDe == null) {
                dernierDe = itrDes.next();
            } else {
                De nouveauDe = itrDes.next();
                if(dernierDe.compareTo(nouveauDe) != 0) {
                    return false;
                }
                dernierDe = nouveauDe;
            }
        }
        return true;
	}

}
