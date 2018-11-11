package generic;

import java.util.Iterator;

/**
 * Classe abstraite qui représente les attributs communs à tous les jeux de dés. Pour implémenter les règles d'un
 * jeu particulier, simplement modifier la méthode calculerScoreTour().
 */
public abstract class Jeu {
	
	protected int nbTours;
	private int tourCourant = 0;
	protected boolean peutPasserAuSuivant = false;
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
	    	joueurCourant = collJoueurs.iterator().next();
	}

    /**
     * Obtient le nombre de tours du jeu
     * @return nb de tours
     */
    public int getNbTours() {
        return nbTours;
    }

    /**
     * Obtient la collection de dés
     * @return Collection de dés
     */
    public CollectionDes getCollDes() {
        return collDes;
    }

    /**
     * Obtient la collection de joueurs
     * @return collection de joueurs
     */
    public CollectionJoueurs getCollJoueurs() {
        return collJoueurs;
    }

    /**
     * Simule une partie.
     */
	public void jouer() {
	    while (tourCourant <= nbTours-1) {
			effectuerUnTour();
        }
        calculerLeVainqueur();
    }

    /**
     * Effectue un tour
     */
    public void effectuerUnTour() {
        Iterator<Joueur> itrJ = collJoueurs.iterator();
        while (itrJ.hasNext()) {
            if(peutPasserAuSuivant) {
                joueurCourant = itrJ.next();
            }
            calculerScoreTour();
        }

        // Passe au tour suivant et on ré-initialise le joueur courant au premier joueur.
        tourCourant++;
        joueurCourant = collJoueurs.iterator().next();
    }

    /**
     * Calcule le score du joueur courant pour le tour actuel et détermine si il faut passer au prochain joueur.
     * À redéfinir pour des règles de jeu précises.
     */
	public void calculerScoreTour() {
        collDes.brasserDes();
        int score = strat.calculerScoreTour(this);
        joueurCourant.ajouterAuScore(score);
        peutPasserAuSuivant = true;
    }

    /**
     * Trie les joueurs du gagnant au perdant dépendement de leur score et les affiche dans la console.
     */
    public void calculerLeVainqueur() {
        Joueur[] tab = strat.calculerLeVainqueur(this);
        System.out.println("Partie terminée !");
        System.out.println("<-- Tableau des scores -- >");
        int index = 1;
        for (Joueur j :
                tab) {
            System.out.println(index + ": " + j.toString());
            index++;
        }
    }

    /**
     * Obtient le tour courant
     * @return tour courant
     */
	public int getTourCourant() { return tourCourant+1; }

    /**
     * Obtient si on peut passer au joueur suivant
     * @return Vrai si on peut, faux sinon
     */
	public boolean peutPasserAuSuivant() {
		return peutPasserAuSuivant;
	}
    
}
