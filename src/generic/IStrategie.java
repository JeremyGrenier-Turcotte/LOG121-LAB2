package generic;

public interface IStrategie {
	
	Joueur[] calculerLeVainqueur(Jeu jeu);
	int calculerScoreTour(Jeu jeu);
}
