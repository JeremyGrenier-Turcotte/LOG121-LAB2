package bunco;

import generic.CollectionDes;
import generic.CollectionJoueurs;
import generic.IStrategie;
import generic.Jeu;
import generic.Joueur;

public class BuncoPlus extends Jeu{

	int tourCourant = 0;

	public BuncoPlus(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie strat) {
		super(collDes, collJoueurs, strat);
	}

    @Override
    public void calculerScoreTour() {
        /**
         * TODO:
         * 1. brasser tous les dés en appelant collDes.brasserDes()
         * 2. appeler strat.calculerScoreTour()
         * 3. Si le score retourné est 0, LA MÉTHODE FINIT LA.
         * 4. Si le score retourné N'EST PAS 0, ajouter le score au joueur courant
         * 5. Rappeler calculerScoreTour puisque le joueur courant n'a pas fini le tour actuel.
         * Le reste de la logique de jeu est définit dans la classe abstraite Jeu. ne rien faire d'autre.
         */
    }
}
