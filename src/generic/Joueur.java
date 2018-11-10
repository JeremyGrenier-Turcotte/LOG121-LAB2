package generic;

/**
 * Classe représentant un joueur participant à des jeux de dés.
 */
public class Joueur implements Comparable<Joueur> {

	private int id;
	private int score = 0;

    /**
     * Instancie un objet joueur avec un identifiant.
     * @param id identifiant qui servira à distinguer le joueur
     */
	public Joueur(int id){
		this.id = id;
	}

	public int getScore() {
	    return score;
    }

    public int getId() {
	    return id;
    }

    /**
     * Ajoute des gains au score actuel du joueur. Ajouter des gains négatifs pour enlever des points au joueur.
     * @param gains points gagnés ou perdus par le joueur
     */
	public void ajouterAuScore(int gains){
		score += gains;
	}

    /**
     * Compare deux instances de Joueur.
     * @param joueur joueur à comparer avec l'instance actuelle
     * @return 0 si le score des deux joueurs est identique, 1 si le joueur actuel a un plus gros score, -1 sinon.
     */
	@Override
	public int compareTo(Joueur joueur) {
		if(getScore() < joueur.getScore())
		    return -1;
		if(getScore() > joueur.getScore())
		    return 1;
		else
		    return 0;
	}

	/**
	 * Redéfinition du test d'égalité entre deux joueurs
	 * @return true si les id et les scores sont égaux, false sinon
	 */
	@Override
	public boolean equals(Object objet){
		if(objet == null) return false;
		if(!(objet instanceof Joueur)) return false;
		Joueur joueur = (Joueur)objet;
		if(this.getId() == joueur.getId() && this.getScore() == joueur.getScore()){
			return true;
		}
		else{
			return false;
		}
	}

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
