package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.BuncoPlusStrategie;
import generic.Joueur;
import org.junit.Test;

public class TestBuncoPlusStrategie extends TestBaseBunco {

	private BuncoPlusStrategie buncoPlusStrategie;
	private BuncoPlus buncoPlus;

	@Override
    public void setUp() {
	    super.setUp();
	    buncoPlusStrategie = new BuncoPlusStrategie();
	    buncoPlus = new BuncoPlus(collectionDes, collJoueurs, buncoPlusStrategie);
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
	 public void testBunco21Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 1;
		 de2.fausseValeur = 1;
		 de3.fausseValeur = 1;
		 collectionDes.brasserDes();
		 assertEquals(21, buncoPlusStrategie.calculerScoreTour(buncoPlus));
	 }

	 @Test
	 public void testBunco5Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 2;
		 de2.fausseValeur = 2;
		 de3.fausseValeur = 2;
         collectionDes.brasserDes();
		 assertEquals(5, buncoPlusStrategie.calculerScoreTour(buncoPlus));
	 }

	 @Test
	 public void testBunco1Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 1;
		 de2.fausseValeur = 2;
		 de3.fausseValeur = 4;
		 collectionDes.brasserDes();
		 assertEquals(1, buncoPlusStrategie.calculerScoreTour(buncoPlus));
	 }

	 @Test
	 public void testBunco0Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 2;
		 de2.fausseValeur = 3;
		 de3.fausseValeur = 4;
		 collectionDes.brasserDes();
		 assertEquals(0, buncoPlusStrategie.calculerScoreTour(buncoPlus));
	 }

}
