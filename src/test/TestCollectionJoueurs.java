package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import generic.CollectionJoueurs;
import generic.IterateurJoueurs;
import generic.Joueur;

import org.junit.Before;
import org.junit.Test;

public class TestCollectionJoueurs extends TestBase{
	
	private CollectionJoueurs collJoueurs2;
	private Iterator<Joueur> itrJoueur1;
	private Iterator<Joueur> itrJoueur2;
	
	@Test
	public void testAjouterJoueur() {
		collJoueurs2 = new CollectionJoueurs();
		collJoueurs2.ajouterJoueur(new Joueur(1));
		collJoueurs2.ajouterJoueur(new Joueur(2));
		collJoueurs2.ajouterJoueur(new Joueur(3));
		
		assertEquals(collJoueurs, collJoueurs2);
	}

}
