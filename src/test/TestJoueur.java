package test;

import static org.junit.Assert.*;
import generic.Joueur;

import org.junit.Before;
import org.junit.Test;

public class TestJoueur {
	
	private Joueur joueur1;
	private Joueur joueur2;

	@Before
	public void faireAvant(){
		joueur1 = new Joueur(1);
		joueur2 = new Joueur(2);
	}
	
	@Test
	public void constructeurTest() {
		int idJoueur = 1;
		int scoreInitJoueur = 0;
		assertEquals(idJoueur,joueur1.getId());
		assertEquals(scoreInitJoueur, joueur1.getScore());
	}
	
	@Test
	public void scoreSuperieurTest(){
		joueur1.ajouterAuScore(1);
		joueur2.ajouterAuScore(0);
		assertEquals(1,joueur1.compareTo(joueur2));
	}
	
	@Test
	public void scoreInferieurTest(){
		joueur1.ajouterAuScore(0);
		joueur2.ajouterAuScore(1);
		assertEquals(-1,joueur1.compareTo(joueur2));
	}
	
	@Test
	public void memeScoreTest(){
		joueur1.ajouterAuScore(1);
		joueur2.ajouterAuScore(1);
		assertEquals(0,joueur1.compareTo(joueur2));
	}

}
