package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.BuncoPlusStrategie;
import generic.CollectionJoueurs;
import generic.Jeu;
import generic.Joueur;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBuncoPlusStrategie {
    Jeu buncoPlus;
    BuncoPlusStrategie buncoPlusStrategie;
    Joueur joueur1;
    Joueur joueur2;
    Joueur joueur3;
    CollectionJoueurs joueurs;
    
    @Before
    public void instanciation() {
        joueur1 = new Joueur(1);
        joueur2 = new Joueur(2);
        joueur3 = new Joueur(3);
        joueurs = new CollectionJoueurs();
        joueurs.ajouterJoueur(joueur1);
        joueurs.ajouterJoueur(joueur2);
        joueurs.ajouterJoueur(joueur3);
        buncoPlusStrategie = new BuncoPlusStrategie();
        buncoPlus = new BuncoPlus(null, joueurs, buncoPlusStrategie);    	
    }

    @Test
    public void testCalculerVainqueurAvecScoresDifferents() {
        joueur1.ajouterAuScore(10);
        joueur2.ajouterAuScore(20);
        joueur3.ajouterAuScore(30);
        Joueur[] joueurs = buncoPlusStrategie.calculerLeVainqueur(buncoPlus);
        assertSame(joueur3,joueurs[0]);
        assertSame(joueur2,joueurs[1]);
        assertSame(joueur1,joueurs[2]);
    }

    @Test
    public void testCalculerVainqueurAvecScoresIdentiques() {
        joueur1.ajouterAuScore(10);
        joueur2.ajouterAuScore(10);
        joueur3.ajouterAuScore(10);
        Joueur[] joueurs = buncoPlusStrategie.calculerLeVainqueur(buncoPlus);
        assertSame(joueur1,joueurs[0]);
        assertSame(joueur2,joueurs[1]);
        assertSame(joueur3,joueurs[2]);
    }
    
    @Test
    public void testCalculerScoreTour() {
    	
    }

}
