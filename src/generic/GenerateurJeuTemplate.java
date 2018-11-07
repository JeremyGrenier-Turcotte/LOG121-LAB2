package generic;

public abstract class GenerateurJeuTemplate {
	
	protected int nbJoueurs;	
	
	
	public GenerateurJeuTemplate(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public Jeu creerJeuTemplate() {
		CollectionDes cd = creerDes();
		CollectionJoueurs cj = creerJoueurs(nbJoueurs);
		IStrategie strategie = creerStrategie();
		Jeu jeu = creerJeu(cd, cj, strategie);
		return jeu;
	}
	
	public abstract CollectionDes creerDes();

	public abstract CollectionJoueurs creerJoueurs(int nbJoueurs);
	
	public abstract IStrategie creerStrategie();
	
	public abstract Jeu creerJeu(CollectionDes cd, CollectionJoueurs cj, IStrategie strategie);

}
