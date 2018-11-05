package test;

import generic.De;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestDe extends TestBase{

	private De de1;
	private De de2;
	
	@Before
	public void faireAvant(){
		de1 = new De(6);
		de2 = new De(6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void creationDesTest(){
		De d= new De(0);
	}
	
	@Test
	public void constructeurTest() {
		int valeurInitDe = 1;
		assertEquals(valeurInitDe,de1.getValeur());
	}
	
	@Test
	public void valeurSuperieureTest(){
		setValeurDe(de1, 6);
		setValeurDe(de2, 1);
		assertEquals(1, de1.compareTo(de2));
	}
	
	@Test
	public void valeurInferieureTest(){
		setValeurDe(de1, 1);
		setValeurDe(de2, 6);
		assertEquals(-1, de1.compareTo(de2));
	}
	
	@Test
	public void memeValeurTest(){
		setValeurDe(de1, 1);
		setValeurDe(de2, 1);
		assertEquals(0, de1.compareTo(de2));
	}

	@Test
	public void brasserTest(){
		for(int i= 0; i<100;i++){
			de1.brasser();
			if(de1.getValeur()>de1.getNbFaces()){
				fail("Valeur superieur au nombre de faces");
			}
			if(de1.getValeur()<0){
				fail("Valeur inferieur a zero");
			}
			if(de1.getValeur()==0){
				fail("Valeur egale a zero");
			}
		}
	}
}
