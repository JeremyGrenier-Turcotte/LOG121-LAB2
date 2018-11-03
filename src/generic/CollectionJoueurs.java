package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionJoueurs implements Iterable<Joueur>{

	private List<Joueur> joueurs = new ArrayList<>();

	public void ajouterJoueur(Joueur joueur){
		joueurs.add(joueur);
	}

	public int getNbJoueurs() { return joueurs.size(); }

	@Override
	public Iterator<Joueur> iterator() {
        return new IterateurJoueurs(joueurs);
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
		if(joueurs.size() != collJoueurs.joueurs.size()) return false;
		for(int i = 0; i < joueurs.size(); i++){
			if(!(joueurs.get(i).equals(collJoueurs.joueurs.get(i)))){
				return false;
			}
		}
		return true;
	}
}
