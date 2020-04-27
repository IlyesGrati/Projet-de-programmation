
import java.util.*;

public class Zone2 {
	private ArrayList <Tas> list = new ArrayList<Tas>();
	
	public Zone2() {
		ArrayList <Carte> cartes = new ArrayList<Carte>();
		String types[]= {"TR","CA","CO","PI"};
		
		for (int i=2;i<=13;i++) { 
			for (int j=0;j<4;j++) {
				cartes.add(new Carte(i,types[j])); //Remplissage des cartes dans un tableau
			}
		}
		
		Collections.shuffle(cartes); //Mélanger les cartes
		
	
		int pas=0;
		for (int i=0;i<12;i++) { //remplir list
			Tas t=new Tas();
			for (int j=0;j<4;j++) {
				int k = j+pas;
				t.ajouterCarte(cartes.get(k));
			}
			list.add(t);
			pas+=4;
		}
	}
	
	public Carte suppCarte(int ind) { //ind c'est l'indice du tas
		Tas t=list.get(ind);
		int size = t.getSize(); 
		Carte c = t.getElement(size-1);
		t.suppCarte();
		list.set(ind,t);
		return c;
	}
	
	public void ajouterCarte(Carte c,int ind) { //ind c'est l'indice du tas où on va ajouter la carte
		Tas t = list.get(ind);
		t.ajouterCarte(c);
		list.set(ind,t);	
	}
	
	public boolean deplacer(int tasD,int tasA) {
		Tas t1=list.get(tasD);
		Tas t2=list.get(tasA);
		Carte c1=t1.getElement(t1.getSize()-1);
		Carte c2=t2.getElement(t2.getSize()-1);
		
		boolean bool;
		
		if( (c1.getType()==c2.getType() ) && (c1.getVal()==c2.getVal()-1)){
			Carte c = suppCarte(tasD);
			ajouterCarte(c,tasA);
			System.out.println("Déplacement effectué avec succès");
			bool=true;
		}
		else {
			System.out.println("Ce déplacement dans la Zone2 est invalide"); 
			bool=false;
		}
		return bool;
			
	}
	
	public void donner() {
		
		for (int i=0;i<12;i++) {
			Tas t = list.get(i);
			int nbCartes = t.getSize();
			if (nbCartes>=2) {
				t.permuter();
			}
		}
	}
	
	public void afficher() {
		for (int i=5;i<=10;i++) {
			String ind=Integer.toString(i);
			Tas t = list.get(i-5);
			if (t.getSize()!=0) {
				Carte c = t.getElement(t.getSize()-1);
				String ch = c.afficher();
				String res=ind+") "+ch; 
				System.out.printf("%-15s",res);
			}else {
				String res=ind+")";
				System.out.printf("%-15s",res);
			}
			
		}
		System.out.println();
		for (int i=11;i<=16;i++) {
			String ind=Integer.toString(i);
			Tas t = list.get(i-5);
			if (t.getSize()!=0) {
				Carte c = t.getElement(t.getSize()-1);
				String ch = c.afficher();
				String res=ind+") "+ch; 
				System.out.printf("%-15s",res);
			}else{
				
				String res=ind+")";
				System.out.printf("%-15s",res);
			}
			
		}
		
	}
	
	public Tas getTas (int x) {
		return (list.get(x));
	}
}
