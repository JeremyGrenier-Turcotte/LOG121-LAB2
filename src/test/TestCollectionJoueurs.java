package test;

import generic.CollectionJoueurs;
import generic.Joueur;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class TestCollectionJoueurs extends TestBaseBunco {
	
	private CollectionJoueurs collJoueurs2;
	private Iterator<Joueur> itrJoueur1;
	private Iterator<Joueur> itrJoueur2;
	
	@Test
	public void testAjouterJoueur() {
		collJoueurs2 = new CollectionJoueurs();
		Joueur j = new Joueur(2);
		collJoueurs2.ajouterJoueur(new Joueur(1));
		collJoueurs2.ajouterJoueur(j);
		collJoueurs2.ajouterJoueur(new Joueur(3));
		itrJoueur1=collJoueurs2.iterator();
		int index=0;
		while(itrJoueur1.hasNext()){
			Joueur j2=itrJoueur1.next();
			if(index==1){
				assertEquals(j2, j);
			}
			index++;
		}

	}

	@Test
	public void testEquals(){
		collJoueurs2 = new CollectionJoueurs();
		collJoueurs2.ajouterJoueur(new Joueur(1));
		collJoueurs2.ajouterJoueur(new Joueur(2));
		collJoueurs2.ajouterJoueur(new Joueur(3));

		assertEquals(collJoueurs2.equals(collJoueurs),true);

	}
	@Test
	public void getNbJoueur(){

		assertEquals(collJoueurs.getNbJoueurs(),3);

	}

}
