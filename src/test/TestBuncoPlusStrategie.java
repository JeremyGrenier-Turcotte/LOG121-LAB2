package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.BuncoPlusStrategie;
import generic.CollectionJoueurs;
import generic.Jeu;
import generic.Joueur;
import org.junit.Before;
import org.junit.Test;

public class TestBuncoPlusStrategie {
    Jeu buncoPlus;
    BuncoPlusStrategie buncoPlusStrategie;
    Joueur joueur1;
    Joueur joueur2;
    Joueur joueur3;
    CollectionJoueurs joueurs;

    @Before
    public void initialize() {
        joueur1 = new Joueur(1);
        joueur1.ajouterAuScore(1);
        joueur2 = new Joueur(2);
        joueur2.ajouterAuScore(2);
        joueur3 = new Joueur(3);
        joueur3.ajouterAuScore(3);
        joueurs = new CollectionJoueurs();
        joueurs.ajouterJoueur(joueur1);
        joueurs.ajouterJoueur(joueur2);
        joueurs.ajouterJoueur(joueur3);
        buncoPlus = new BuncoPlus(null, null, null);
        buncoPlusStrategie = new BuncoPlusStrategie();
    }

    @Test
    public void testCalculerVainqueur() {
        Joueur[] joueurs = buncoPlusStrategie.calculerLeVainqueur(buncoPlus);
        assertSame(joueur3,joueurs[0]);
    }

}
