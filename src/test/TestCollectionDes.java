package test;

import generic.CollectionDes;
import generic.De;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class TestCollectionDes extends TestBaseBunco {
	
	private CollectionDes collDes2;
	private Iterator<De> itrDes1;
	private Iterator<De> itrDes2;



	@Test
	public void testAjouterDe() {
		collDes2 = new CollectionDes();
		De d = new De(6);
		collDes2.ajouterDe(new De(6));
		collDes2.ajouterDe(d);
		collDes2.ajouterDe(new De(6));
		itrDes1=collDes2.iterator();
		int index=0;
		while(itrDes1.hasNext()){
			De d2=itrDes1.next();
			if(index==1){
				assertEquals(d2, d);
			}
			index++;
		}

	}

	@Test
	public void testEquals(){
		collDes2 = new CollectionDes();
		collDes2.ajouterDe(new De(6));
		collDes2.ajouterDe(new De(6));
		collDes2.ajouterDe(new De(6));

		assertEquals(collDes2.equals(collectionDes),true);

	}
	@Test
	public void getNbDes(){

		assertEquals(collectionDes.getNbDes(),3);

	}

}
