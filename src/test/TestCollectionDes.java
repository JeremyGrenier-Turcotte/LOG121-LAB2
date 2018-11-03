package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import generic.CollectionDes;
import generic.De;
import generic.IterateurDes;

import org.junit.Before;
import org.junit.Test;

public class TestCollectionDes extends TestBase{
	
	private CollectionDes collDes2;
	private Iterator<De> itrDes1;
	private Iterator<De> itrDes2;

	@Test
	public void testAjouterDe() {
		collDes2 = new CollectionDes();
		collDes2.ajouterDe(new De(6));
		collDes2.ajouterDe(new De(6));
		collDes2.ajouterDe(new De(6));
		
		assertEquals(collectionDes, collDes2);
	}

}
