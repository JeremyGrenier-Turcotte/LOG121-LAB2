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
	
	/**
	 * Redéfinition du test d'égalité entre deux collection de dés
	 * @return true si les deux collection ont la même taille et qu'elles 
	 * contiennent les mêmes éléments dans le même ordre. False sinon.
	 */
	@Override
	public boolean equals(Object objet){
		if(objet == null) return false;
		if(!(objet instanceof CollectionDes)) return false;
		CollectionDes collDes = (CollectionDes)objet;
		if(des.size() != collDes.des.size()) return false;
		for(int i = 0; i < des.size(); i++){
			if(!(des.get(i).equals(collDes.des.get(i)))){
				return false;
			}
		}
		return true;
	}
}
