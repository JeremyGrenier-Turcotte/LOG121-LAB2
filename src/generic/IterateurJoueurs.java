package generic;

import java.util.Iterator;

/**
 * Classe qui permet d'itérer dans une collection de tabJoueurs.
 */
public class IterateurJoueurs implements Iterator<Joueur> {

    private int index = 0;
    private Joueur[] tabJoueurs;

    /**
     * Créé une instance d'IterateurJoueurs
     * @param joueurs liste de tabJoueurs
     */
    public IterateurJoueurs(Joueur[] joueurs) {
        this.tabJoueurs = joueurs;
    }

    /**
     * Vérifie si nous ne sommes pas arrivés à la fin de la collection.
     * @return vrai si nous ne sommes pas à la fin, faux sinon.
     */
	@Override
	public boolean hasNext() {

        return index >= tabJoueurs.length || tabJoueurs[index] == null ? false : true;
	}

    /**
     * Obtient le prochain joueur de la collection.
     * @return le prochain Joueur.
     */
	@Override
	public Joueur next() {
        return tabJoueurs[index++];
	}

}
