package generic;

public interface GenerateurJeuTemplate {
	
	public Jeu creerJeu(CollectionDes collDes, CollectionJoueurs collJoueurs, IStrategie stratJeu);
	public CollectionJoueurs creerJoueurs();
	public CollectionDes creerDes();
}
