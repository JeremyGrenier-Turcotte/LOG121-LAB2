package generic;

import java.util.Iterator;

public class CollectionJoueurs implements Iterable<Joueur>{

	private Joueur[] tabJoueurs = new Joueur[10];
	private int index = 0;

	public void ajouterJoueur(Joueur joueur){
		tabJoueurs[index++] = joueur;
	}

	public int getNbJoueurs() {
	    return index;
    }

	@Override
	public Iterator<Joueur> iterator() {
        return new IterateurJoueurs(tabJoueurs);
	}
	
	/**
	 * Redéfinition du test d'égalité entre deux collection de joueurs
	 * @return true si les deux collection ont la même taille et qu'elles 
	 * contiennent les mêmes éléments dans le même ordre. False sinon.
	 */
	@Override
	public boolean equals(Object objet){

		if(objet == null) return false;
		if(!(objet instanceof CollectionJoueurs)) return false;

		CollectionJoueurs collJoueurs = (CollectionJoueurs)objet;
		if(getNbJoueurs() != collJoueurs.getNbJoueurs()) return false;

		int i = 0;
		Iterator<Joueur> itrJoueurs = collJoueurs.iterator();
		while (itrJoueurs.hasNext()) {
		    Joueur j = itrJoueurs.next();
		    if(!j.equals(tabJoueurs[i])) {
		        return false;
            }
            i++;
        }
        return true;
	}
}
