package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe représentant une collection de dés.
 */
public class CollectionDes implements Iterable<De>{
	
	private List<De> des = new ArrayList<>();

    /**
     * Ajoute un dé à la collection
     * @param de dé à ajouter
     */
	public void ajouterDe(De de){
		des.add(de);
	}

    /**
     * Brasse tous les dés de la collection.
     */
	public void brasserDes(){
        for (De de :
                des) {
            de.brasser();
        }
	}

    /**
     * Créé un itérateur de dés.
     * @return
     */
	@Override
	public Iterator<De> iterator() {
		return new IterateurDes(des);
	}
}
