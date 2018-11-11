package test;

import static org.junit.Assert.*;

import bunco.BuncoPlus;
import bunco.BuncoPlusStrategie;
import org.junit.Test;

public class TestBuncoPlus extends TestBaseBunco {

    private BuncoPlus buncoPlus;

    @Override
    public void setUp() {
        super.setUp();
        buncoPlus = new BuncoPlus(collectionDes, collJoueurs, new BuncoPlusStrategie());
    }

    @Test
    public void testBuncoPlusConstructor() {
        assertEquals(6, buncoPlus.getNbTours());
        assertEquals(1, buncoPlus.getTourCourant());
        assertEquals(false, buncoPlus.peutPasserAuSuivant());
        assertEquals(collectionDes, buncoPlus.getCollDes());
        assertEquals(collJoueurs, buncoPlus.getCollJoueurs());
    }

    @Test
    public void testBunco21Pts() {
        de1.fausseValeur = 1;
        de2.fausseValeur = 1;
        de3.fausseValeur = 1;

        buncoPlus.calculerScoreTour();
        assertEquals(21, joueur1.getScore());
        assertEquals(true, buncoPlus.peutPasserAuSuivant());
        assertEquals(1, buncoPlus.getTourCourant());
    }

    @Test
    public void testBunco5Pts() {
        de1.fausseValeur = 2;
        de2.fausseValeur = 2;
        de3.fausseValeur = 2;

        buncoPlus.calculerScoreTour();
        assertEquals(5, joueur1.getScore());
        assertEquals(false, buncoPlus.peutPasserAuSuivant());
        assertEquals(1, buncoPlus.getTourCourant());
    }

    @Test
    public void testBunco1Pts() {
        de1.fausseValeur = 1;
        de2.fausseValeur = 2;
        de3.fausseValeur = 2;

        buncoPlus.calculerScoreTour();
        assertEquals(1, joueur1.getScore());
        assertEquals(false, buncoPlus.peutPasserAuSuivant());
        assertEquals(1, buncoPlus.getTourCourant());
    }

    @Test
    public void testBunco0Pts() {
        de1.fausseValeur = 2;
        de2.fausseValeur = 3;
        de3.fausseValeur = 4;

        buncoPlus.calculerScoreTour();
        assertEquals(0, joueur1.getScore());
        assertEquals(true, buncoPlus.peutPasserAuSuivant());
        assertEquals(1, buncoPlus.getTourCourant());
    }

    @Test
    public void testEffectuerTourPasseAuTourSuivant() {
        buncoPlus.effectuerUnTour();
        assertEquals(2, buncoPlus.getTourCourant());
        de1.fausseValeur = 4;
        de2.fausseValeur = 5;
        de3.fausseValeur = 6;
        buncoPlus.effectuerUnTour();
        assertEquals(3, buncoPlus.getTourCourant());
    }

    @Test
    public void testClassementFinal() {
        de1.estAleatoire = true;
        de2.estAleatoire = true;
        de3.estAleatoire = true;

        System.out.println("Test d'une partie de bunco+");
        buncoPlus.jouer();
        // À la fin d'une partie nous sommes rendus au 7e tour, qu'on ne jouera pas car une partie de bunco se finit a 6
        assertEquals(7, buncoPlus.getTourCourant());
    }
}
