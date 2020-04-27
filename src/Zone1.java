

public class Zone1 {
	private Carte[] tab ;
	public Zone1(){
		String types[]= {"TR","CA","CO","PI"};
		tab = new Carte[4];
		for (int i=0;i<4;i++) {
			tab[i]=new Carte(1,types[i]);
		}
	}
	public void afficher() {
		for (int i=0 ;i<=3;i++){
			String ind=Integer.toString(i+1);
			String ch = tab[i].afficher();
			String res = ind+") "+ch;
			System.out.printf("%-15s",res);
		}

	}
	void ajouterCarte(int ind , Carte c) {
		tab[ind]=c;
	}
	
	public Carte getCarte (int x) {
		return tab[x];
	}

}