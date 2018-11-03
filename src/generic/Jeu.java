package generic;

import java.util.Iterator;

/**
 * Classe abstraite qui représente les attributs communs à tous les jeux de dés. Pour implémenter les règles d'un
 * jeu particulier, simplement modifier la méthode calculerScoreTour().
 */
public abstract class Jeu {
	
	protected int nbTours;
	protected Joueur joueurCourant;
	protected IStrategie strat;
    protected CollectionDes collDes;
    protected CollectionJoueurs collJoueurs;

    /**
     * Instancie un objet Jeu
     * @param collDes collection de dés du jeu
     * @param collJoueurs collection de joueurs du jeu
     * @param strat stratégie de score du jeu
     */
	public Jeu(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie strat){
	    	this.collDes = collDes;
	    	this.collJoueurs = collJoueurs;
	    	this.strat = strat;
	}

    /**
     * Simule une partie.
     */
	public void jouer() {
	    int tour = 0;
	    while (tour < nbTours) {
	        effectuerTour();
	        tour++;
        }
        calculerLeVainqueur();
    }

    /**
     * Fait joueur tous les joueurs pour un tour.
     */
	public void effectuerTour(){
        Iterator<Joueur> itrJ = collJoueurs.iterator();
        while (itrJ.hasNext()) {
            joueurCourant = itrJ.next();
            calculerScoreTour();
        }
	}

    /**
     * Calcule le score du joueur courant pour le tour actuel. À définir dans les classes enfants.
     */
	public void calculerScoreTour() {

	}

    /**
     * Trie les joueurs selon leur score en ordre décroissant et les affiche dans la console.
     */
    public void calculerLeVainqueur() {

    }
}
