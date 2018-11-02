package generic;

import java.util.Random;

/**
 * Classe représentant un dé qui peut être utilisé dans n'importe quel jeu de dé.
 */
public class De implements Comparable<De> {

	// Valeur arbitraire de départ, peu importe le nombre de faces qu'un dé possède il aura toujours une face qui vaut 1
	int valeur = 1;
    int nbFaces;

    /**
     * Instancie un objet dé avec un nombre de faces défini.
     * @param nbFaces Nombre de faces que le dé possède
     */
	public De(int nbFaces){
		this.nbFaces = nbFaces;
	}

    /**
     * Obtient la valeur actuelle du dé.
     * @return valeur du dé
     */
	public int getValeur() {
		return valeur;
	}

	public int getNbFaces() {
	    return nbFaces;
    }

    /**
     * Compare deux instances de dé.
     * @param de dé qu'on veut comparer avec le dé actuel.
     * @return 0 si les valeurs des deux dés sont identiques, 1 si le dé actuel a une plus grande valeur que l'autre,
     * -1 sinon.
     */
	@Override
	public int compareTo(De de) {
        if(getValeur() < de.getValeur())
		    return -1;
        if(getValeur() > de.getValeur())
            return 1;
        else
            return 0;
	}

    /**
     * Brasse le dé de façon aléatoire et met à jour la valeur du dé en fonction du résultat du brassage.
     */
	public void brasser(){
	    // Il faut mettre + 1 car la limite supérieure de Random.nextInt() est exclusive.
        Random r = new Random();
        valeur = r.nextInt(nbFaces + 1);
	}
}
