package test;

import static org.junit.Assert.*;

import bunco.GenerateurBuncoPlus;
import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.De;
import generic.Joueur;
import org.junit.Test;

import java.util.Iterator;

public class TestGenerateurBuncoPlus {

	private GenerateurBuncoPlus gbp = new GenerateurBuncoPlus(4);

	@Test
	public void testCreationDes() {
		CollectionDes cd = gbp.creerDes();

		//3 des au bunco plus
		assertEquals(cd.getNbDes(), 3);

		Iterator<De> i = cd.iterator();

		while(i.hasNext()){
			De d = i.next();

			assertEquals(d.getNbFaces(),6);
		}
	}


	@Test
	public void testCreationJoueur(){

		CollectionJoueurs cj = gbp.creerJoueurs();

		assertEquals(cj.getNbJoueurs(),4);

		Iterator<Joueur> i = cj.iterator();
		int id = 0;
		while(i.hasNext()){
			Joueur j = i.next();
			id++;
			assertEquals(j.getId(),id);
		}

	}

}
