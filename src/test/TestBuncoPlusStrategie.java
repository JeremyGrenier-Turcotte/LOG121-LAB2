package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.BuncoPlusStrategie;
import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.De;
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
	FauxDe de1;
	FauxDe de2;
	FauxDe de3;
	CollectionJoueurs joueurs;
	CollectionDes des;

	@Before
	public void instanciation() {
		joueur1 = new Joueur(1);
		joueur2 = new Joueur(2);
		joueur3 = new Joueur(3);
		joueurs = new CollectionJoueurs();
		joueurs.ajouterJoueur(joueur1);
		joueurs.ajouterJoueur(joueur2);
		joueurs.ajouterJoueur(joueur3);
		de1 = new FauxDe(6);
		de2 = new FauxDe(6);
		de3 = new FauxDe(6);
		des = new CollectionDes();
		des.ajouterDe(de1);
		des.ajouterDe(de2);
		des.ajouterDe(de3);
		buncoPlusStrategie = new BuncoPlusStrategie();
		buncoPlus = new BuncoPlus(des, joueurs, buncoPlusStrategie);    	
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

	/**
	 * Cette classe permet de créer des dés pipés
	 * @author Philippe Nyamba
	 */
	 private class FauxDe extends De{

		int fausseValeur;

		public FauxDe(int nbFaces) {
			super(nbFaces);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void brasser() {
			this.valeur = fausseValeur;
		}

	 }


	 @Test
	 public void testBunco21Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 1;
		 de2.fausseValeur = 1;
		 de2.fausseValeur = 1;
		 Joueur joueurCourant = buncoPlus.getJoueurCourant();
		 assertEquals(21, buncoPlusStrategie.calculerScoreTour(buncoPlus));
		 assertNotSame(joueurCourant, buncoPlus.getJoueurCourant());
	 }

	 @Test
	 public void testBunco5Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 2;
		 de2.fausseValeur = 2;
		 de2.fausseValeur = 2;
		 Joueur joueurCourant = buncoPlus.getJoueurCourant();
		 assertEquals(5, buncoPlusStrategie.calculerScoreTour(buncoPlus));
		 assertSame(joueurCourant, buncoPlus.getJoueurCourant());
	 }

	 @Test
	 public void testBunco1Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 1;
		 de2.fausseValeur = 2;
		 de2.fausseValeur = 4;
		 Joueur joueurCourant = buncoPlus.getJoueurCourant();
		 assertEquals(1, buncoPlusStrategie.calculerScoreTour(buncoPlus));
		 assertSame(joueurCourant, buncoPlus.getJoueurCourant());
	 }

	 @Test
	 public void testBunco0Pts() {
		 //tourCourant = 1 par défaut
		 de1.fausseValeur = 2;
		 de2.fausseValeur = 3;
		 de2.fausseValeur = 4;
		 Joueur joueurCourant = buncoPlus.getJoueurCourant();
		 assertEquals(0, buncoPlusStrategie.calculerScoreTour(buncoPlus));
		 assertNotSame(joueurCourant, buncoPlus.getJoueurCourant());
	 }

}
