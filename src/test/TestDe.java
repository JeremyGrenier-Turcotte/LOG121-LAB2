package test;

import static org.junit.Assert.*;
import generic.De;

import org.junit.Before;
import org.junit.Test;

public class TestDe {

	private De de1;
	private De de2;
	
	private void setValeur(De de, int valeur){
		while(de.getValeur() != valeur)
		{
		       de.brasser();
		}
	}
	
	@Before
	public void faireAvant(){
		de1 = new De(6);
		de2 = new De(6);
	}
	
	@Test
	public void constructeurTest() {
		int valeurInitDe = 1;
		assertEquals(valeurInitDe,de1.getValeur());
	}
	
	public void valeurSuperieureTest(){
		setValeur(de1, 6);
		setValeur(de2, 1);
		assertEquals(1, de1.compareTo(de2));
	}
	
	public void valeurInferieureTest(){
		setValeur(de1, 1);
		setValeur(de2, 6);
		assertEquals(-1, de1.compareTo(de2));
	}
	
	public void memeValeurTest(){
		setValeur(de1, 1);
		setValeur(de2, 1);
		assertEquals(0, de1.compareTo(de2));
	}

}
