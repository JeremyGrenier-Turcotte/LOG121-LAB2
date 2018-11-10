package test;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.De;
import generic.Joueur;
import org.junit.Before;

/**
 * Classe abstraite permettant la réutilisation de méthodes et d'objets partagées pour tester les classes du
 * package bunco.
 */
public abstract class TestBaseBunco {

    protected CollectionJoueurs collJoueurs;
    protected CollectionDes collectionDes;

    protected FauxDe de1;
    protected FauxDe de2;
    protected FauxDe de3;

    protected Joueur joueur1;
    protected Joueur joueur2;
    protected Joueur joueur3;

    /**
     * Initialisation des variables
     */
    @Before
    public void setUp() {
        de1 = new FauxDe(6);
        de2 = new FauxDe(6);
        de3 = new FauxDe(6);
        collectionDes = new CollectionDes();
        collectionDes.ajouterDe(de1);
        collectionDes.ajouterDe(de2);
        collectionDes.ajouterDe(de3);

        joueur1 = new Joueur(1);
        joueur2 = new Joueur(2);
        joueur3 = new Joueur(3);
        collJoueurs = new CollectionJoueurs();
        collJoueurs.ajouterJoueur(joueur1);
        collJoueurs.ajouterJoueur(joueur2);
        collJoueurs.ajouterJoueur(joueur3);
    }

    /**
     * Cette classe permet de créer des dés pipés
     * @author Philippe Nyamba
     */
    protected class FauxDe extends De{

        int fausseValeur = 1;
        boolean estAleatoire = false;

        public FauxDe(int nbFaces) {
            super(nbFaces);
        }

        @Override
        public void brasser() {
            if(estAleatoire) {
                super.brasser();
            } else {
                valeur = fausseValeur;
            }
        }

    }
}
