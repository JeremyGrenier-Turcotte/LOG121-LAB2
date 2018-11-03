package test;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.De;
import generic.Joueur;
import org.junit.Before;

public abstract class TestBase {

    protected CollectionJoueurs collJoueurs;
    protected CollectionDes collectionDes;

    @Before
    public void setUp() {
        collJoueurs = new CollectionJoueurs();
        collJoueurs.ajouterJoueur(new Joueur(1));
        collJoueurs.ajouterJoueur(new Joueur(2));
        collJoueurs.ajouterJoueur(new Joueur(3));

        collectionDes = new CollectionDes();
        collectionDes.ajouterDe(new De(6));
        collectionDes.ajouterDe(new De(6));
        collectionDes.ajouterDe(new De(6));
    }

    protected void setValeurDe(De de, int valeur) {
        while (de.getValeur() != valeur) {
            de.brasser();
        }
    }
}
