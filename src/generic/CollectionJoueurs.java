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
}
