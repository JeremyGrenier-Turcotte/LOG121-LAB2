package generic;

/**
 * Classe qui instancie un jeu avec les composantes nécessaires.
 */
public abstract class GenerateurJeuTemplate {
	
	protected int nbJoueurs;

    /**
     * Instancie le template selon le nombre de joueurs
     * @param nbJoueurs nb de joueurs
     */
	public GenerateurJeuTemplate(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

    /**
     * Méthode template qui instancie un jeu selon les méthodes définies par les classes enfants.
     * @return Jeu
     */
	public Jeu creerJeuTemplate() {
		CollectionDes cd = creerDes();
		CollectionJoueurs cj = creerJoueurs();
		IStrategie strategie = creerStrategie();
		Jeu jeu = creerJeu(cd, cj, strategie);
		return jeu;
	}

    /**
     * Créé une collection de dés
     * @return Collection de dés
     */
	public abstract CollectionDes creerDes();

    /**
     * Créé une collection de joueurs
     * @return Collection de joueurs
     */
	public abstract CollectionJoueurs creerJoueurs();

    /**
     * Créé une stratégie
     * @return stratégie
     */
	public abstract IStrategie creerStrategie();

    /**
     * Méthode qui instancie un jeu selon les paramètres donnés.
     * @param cd Collection de dés
     * @param cj Collection de joueurs
     * @param strategie stratégie
     * @return Jeu
     */
	public abstract Jeu creerJeu(CollectionDes cd, CollectionJoueurs cj, IStrategie strategie);

}
