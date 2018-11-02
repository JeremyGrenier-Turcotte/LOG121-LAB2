package generic;

import java.util.Iterator;
import java.util.List;

/**
 * Classe qui permet d'itérer dans une collection de joueurs.
 */
public class IterateurJoueurs implements Iterator<Joueur> {

    private int index = 0;
    private List<Joueur> joueurs;

    /**
     * Créé une instance d'IterateurJoueurs
     * @param joueurs liste de joueurs
     */
    public IterateurJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    /**
     * Vérifie si nous ne sommes pas arrivés à la fin de la collection.
     * @return vrai si nous ne sommes pas à la fin, faux sinon.
     */
	@Override
	public boolean hasNext() {
        return index >= joueurs.size() ? false : true;
	}

    /**
     * Obtient le prochain joueur de la collection.
     * @return le prochain Joueur.
     */
	@Override
	public Joueur next() {
        Joueur j = joueurs.get(index);
        index++;
        return j;
	}

}
