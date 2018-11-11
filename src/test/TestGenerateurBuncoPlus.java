package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.GenerateurBuncoPlus;
import generic.*;
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

	@Test
    public void testCreerJeuTemplate() {
	    BuncoPlus buncoPlus = (BuncoPlus) gbp.creerJeuTemplate();
        assertEquals(6, buncoPlus.getNbTours());

	    assertEquals(4, buncoPlus.getCollJoueurs().getNbJoueurs());
        Iterator<Joueur> itrJ = buncoPlus.getCollJoueurs().iterator();
        while (itrJ.hasNext()) {
            assertEquals(0, itrJ.next().getScore());
        }

	    assertEquals(3, buncoPlus.getCollDes().getNbDes());
        Iterator<De> itrDes = buncoPlus.getCollDes().iterator();
        while (itrDes.hasNext()) {
            assertEquals(6, itrDes.next().getNbFaces());
        }
    }

}
