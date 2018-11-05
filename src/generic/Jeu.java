package generic;

import java.util.Iterator;

/**
 * Classe abstraite qui représente les attributs communs à tous les jeux de dés. Pour implémenter les règles d'un
 * jeu particulier, simplement modifier la méthode calculerScoreTour().
 */
public abstract class Jeu {
	
	protected int nbTours;
	protected boolean peutPasserAuSuivant = true;
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

	public Joueur getJoueurCourant() {
	    return joueurCourant;
    }

    public int getNbTours() {
        return nbTours;
    }

    public CollectionDes getCollDes() {
        return collDes;
    }

    public CollectionJoueurs getCollJoueurs() {
        return collJoueurs;
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
	    collDes.brasserDes();
        Iterator<Joueur> itrJ = collJoueurs.iterator();
        while (itrJ.hasNext()) {
            if(peutPasserAuSuivant) {
                joueurCourant = itrJ.next();
            }
            calculerScoreTour();
        }
	}

    /**
     * Calcule le score du joueur courant pour le tour actuel et passe au prochain joueur.
     */
	public void calculerScoreTour() {
        int score = strat.calculerScoreTour(this);
        joueurCourant.ajouterAuScore(score);
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
}
