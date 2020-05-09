
import java.util.ArrayList;

public class Tas {
	private ArrayList<Carte> list ;
	
	public Tas() {
		list = new ArrayList <Carte> ();
		
	}
	
	public void ajouterCarte (Carte c) {
		list.add(c);
	}
	
	public void suppCarte () {
		list.remove(list.size()-1);
	}
	
	public int getSize() {
		return list.size();
	}
	
	
	public Carte getElement(int ind) {
		return list.get(ind);
	}
	
	public void permuter() {
		Carte dessus=getElement(getSize()-1);
		Carte dessous=getElement(getSize()-2);
		suppCarte();
		suppCarte();
		list.add(dessus);
		list.add(dessous);
	}
		
}