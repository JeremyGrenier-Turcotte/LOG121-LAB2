package test;

import static org.junit.Assert.*;
import generic.CollectionDes;
import generic.De;
import generic.IterateurDes;

import org.junit.Before;
import org.junit.Test;

public class TestCollectionDes {
	
	private De de1;
	private De de2;
	private De de3;
	private CollectionDes collDes1;
	private CollectionDes collDes2;
	private IterateurDes itrDes1;
	private IterateurDes itrDes2;
	
	@Before
	public void faireAvant(){
		de1 = new De(6);
		de2 = new De(6);
		de3 = new De(6);
		
		collDes1 = new CollectionDes();
		collDes1.ajouterDe(de1);
		collDes1.ajouterDe(de2);
		collDes1.ajouterDe(de3);
		
		itrDes1 = new IterateurDes(collDes1);
	}

	@Test
	public void testAjouterDe() {
		collDes2 = new CollectionDes();
		collDes2.ajouterDe(de1);
		collDes2.ajouterDe(de2);
		collDes2.ajouterDe(de3);
		
		assertEquals(collDes1, collDes2);
	}

}
