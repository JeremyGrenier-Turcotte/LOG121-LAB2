package generic;

import java.util.Iterator;

/**
 * Classe représentant une collection de dés.
 */
public class CollectionDes implements Iterable<De>{
	
	private De[] tabDes = new De[10];
	private int index = 0;

    /**
     * Obtient le nombre de dés que contient la collection.
     * @return nombre de dés contenus
     */
	public int getNbDes() {
	    return index;
    }

    /**
     * Ajoute un dé à la collection
     * @param de dé à ajouter
     */
	public void ajouterDe(De de){
		tabDes[index++] = de;
	}

    /**
     * Brasse tous les dés de la collection.
     */
	public void brasserDes(){
        for (De de :
                tabDes) {
        	if(de != null)
            de.brasser();
        }
	}

    /**
     * Créé un itérateur de dés.
     * @return
     */
	@Override
	public Iterator<De> iterator() {
		return new IterateurDes(tabDes);
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
		if(getNbDes() != collDes.getNbDes()) return false;

		int i =0;
		Iterator<De> itrDes = collDes.iterator();
		while (itrDes.hasNext()) {
		    De de = itrDes.next();
		    if(!de.equals(tabDes[i])) {
		        return false;
            }
            i++;
        }

		return true;
	}
}
