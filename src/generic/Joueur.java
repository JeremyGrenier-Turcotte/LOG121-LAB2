package generic;

public class Joueur implements Comparable<Joueur> {

	int id;
	int score;
	
	public Joueur(int id){
		this.id = id;
		this.score = 0;
	}
	
	public void ajouterAuScore(int score){
		
	}
	
	@Override
	public int compareTo(Joueur o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
