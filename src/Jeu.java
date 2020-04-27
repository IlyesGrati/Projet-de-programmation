
import java.util.Scanner;

public class Jeu {
	private Zone1 z1;
	private Zone2 z2 ;
	private int verif ;
    public Jeu() {
    	z1=new Zone1();
    	z2=new Zone2();
    	verif = 1 ;
    }
    public int  getVerif() {
    	return(verif);
    }
    public void setVerif(int n) {
    	verif=n;
    }
	
	public void deplacerCarte (int tasD,int tasA) {
		if ((tasD>=1 && tasD <= 16) && (tasA>=1 && tasA<=16)) { // Controle sur les indices entre 1 et 16
			if( (tasD >=5 && tasD<=16) && (tasA >=5 && tasA<=16) ) { //Déplacement dans la zone2
				 if (z2.deplacer(tasD-5, tasA-5)) { // verifier si le deplacement est effectué ?
					 setVerif(getVerif()+1);}}				
			else {
				if ((tasD >=5 && tasD<=16) && (tasA >=1 && tasA<=4)) { //Déplacement Zone2->Zone1
				        Tas t2=z2.getTas(tasD-5);
				        Carte c1=z1.getCarte(tasA-1);
				        Carte c2=t2.getElement(t2.getSize()-1);
				            if( (c1.getVal()==c2.getVal()-1)) {
				            	Carte c = z2.suppCarte(tasD-5);
								 setVerif(getVerif()+1);
				            	z1.ajouterCarte(tasA-1,c);
				            	System.out.println("Déplacement effectué avec succès");}}									        
			       else { 
			    	   if( ((tasD >=1 && tasD<=4) && (tasA >=1 && tasA<=4))) //Déplacement Zone1
			    	        { 
							 System.out.println();
			    		     System.out.println("Le déplacement Zone1->Zone1 n'est pas permis");
			    	        }
			    	   else { if (((tasD >=1 && tasD<=4) && (tasA >=5 && tasA<=16))) //Déplacement Zone1->Zone2
							System.out.println();
			    		    System.out.println("Le déplacement Zone1->Zone2 n'est pas permis"); }}}}	
		else {
			System.out.println("Les indices des tas sont incorrects");}}	
	
	public void operation(int numOp) {
		switch (numOp) {
			case 1: 
				System.out.println("Donner le tas de départ et le tas d'arrivé : "); 	
				Scanner sc=new Scanner(System.in);
				int nb=sc.nextInt();            
				sc.nextLine(); 
				int nb1=sc.nextInt();    
				sc.nextLine(); 
				deplacerCarte(nb,nb1);
				System.out.println();
				z1.afficher();
				System.out.println();
				System.out.println();
				System.out.println();
				z2.afficher();
				break;
			case 2:
				if(getVerif()>=1) {
				z2.donner();
				System.out.println("Le clic sur le bouton Donner est effectué avec succès");}
				else { 
					System.out.println();
					System.out.println("Vous pouvez pas appuyer sur le bouton Donner 2 fois successives sans effectuer aucun déplacement correct");
				} 
				System.out.println();
				z1.afficher();
				System.out.println();
				System.out.println();
				System.out.println();
				z2.afficher();
				setVerif(0);
				break;
			case 3:
				aide();
		}
	}
	public void mis_a_jour_menu() {
		System.out.println("Bienvenue au Jeu CRUEL !! Je vous dipose le menu du choix .. Bonne Partie ");
		System.out.println();
		System.out.println("Menu du choix :");
		System.out.println();
		System.out.println("Si vous voulez déplacer une carte tapez 1");
		System.out.println();
		System.out.println("Si vous voulez utiliser le bouton Donner tapez 2");
		System.out.println();
		System.out.println("Si vous voulez de l'aide tapez 3");
		System.out.println();
		System.out.println("******************Début du jeu******************");
		System.out.println();
		z1.afficher();
		System.out.println();
		System.out.println();
		System.out.println();

		z2.afficher();
	}
	
	public void aide() {
		String ch21="";
		String ch22="";
		for (int i=0;i<12;i++) {
			Tas t=z2.getTas(i);
			Carte c2=t.getElement(t.getSize()-1);
			for (int j=0;j<4;j++) { //Rechercher les possibiltés de deplacement de la Zone2 vers la Zone1
				Carte c1=z1.getCarte(j);
				if (c1.getVal()==c2.getVal()-1) {
					String is=Integer.toString(i+5);
					String js=Integer.toString(j+1);
					ch21+=is+"->"+js+"   ";
				}
			}
			for (int j=0;j<12;j++) { //Rechercher les possibiltés de deplacement dans la Zone2				
				if (j==i) {
					continue;
				}else {
					Tas t2=z2.getTas(j);
					Carte c22=t2.getElement(t2.getSize()-1);
					if ((c2.getVal()==c22.getVal()-1)&&(c2.getType()==c22.getType())) {
						String is=Integer.toString(i+5);
						String js=Integer.toString(j+5);
						ch22+=is+"->"+js+"   ";
					}
				}
			}
		}
		if (ch21!=""||ch22!="") { // S'il y a des possibilités de deplacements
			System.out.println("CRUEL vous aide ===>");
			String ch=ch21+ch22;
			System.out.println(ch);
		}else {
			System.out.println("Oups!!! Vous ne pouvez déplacer aucune carte");
		}
	}
	

}