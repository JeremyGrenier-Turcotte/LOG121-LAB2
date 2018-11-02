package generic;

import java.util.Iterator;
import java.util.List;

/**
 * Classe qui permet d'itérer dans une collection de dés.
 */
public class IterateurDes implements Iterator<De> {

    private int index = 0;
    private List<De> des;

    /**
     * Instancie un itérateur selon une liste de dés donnée.
     * @param des liste de dés ou on veut itérer
     */
	public IterateurDes(List<De> des) {
	    this.des = des;
    }

    /**
     * Vérifie si nous ne sommes pas arrivés à la fin de la collection.
     * @return vrai si nous ne sommes pas à la fin, faux sinon.
     */
	@Override
	public boolean hasNext() {
		return index >= des.size() ? false : true;
	}

    /**
     * Obtient le prochain dé de la collection.
     * @return le prochain De.
     */
	@Override
	public De next() {
	    De de = des.get(index);
	    index++;
		return de;
	}

}
