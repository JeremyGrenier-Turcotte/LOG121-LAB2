package test;

import static org.junit.Assert.*;
import generic.CollectionJoueurs;
import generic.IterateurJoueurs;
import generic.Joueur;

import org.junit.Before;
import org.junit.Test;

public class TestCollectionJoueurs {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueur3;
	private CollectionJoueurs collJoueurs1;
	private CollectionJoueurs collJoueurs2;
	private IterateurJoueurs itrJoueur1;
	private IterateurJoueurs itrJoueur2;
	
	@Before
	public void faireAvant(){
		joueur1 = new Joueur(1);
		joueur2 = new Joueur(2);
		joueur3 = new Joueur(3);
		
		collJoueurs1 = new CollectionJoueurs();
		collJoueurs1.ajouterJoueur(joueur1);
		collJoueurs1.ajouterJoueur(joueur2);
		collJoueurs1.ajouterJoueur(joueur3);
		
		itrJoueur1 = new IterateurJoueurs(collJoueurs1);
	}
	
	@Test
	public void testAjouterJoueur() {
		collJoueurs2 = new CollectionJoueurs();
		collJoueurs2.ajouterJoueur(joueur1);
		collJoueurs2.ajouterJoueur(joueur2);
		collJoueurs2.ajouterJoueur(joueur3);
		
		assertEquals(collJoueurs1, collJoueurs2);
	}

}
