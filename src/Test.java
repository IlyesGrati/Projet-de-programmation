import java.util.Scanner;

public class Test {
	
	public static Jeu j = new Jeu();
	public static boolean ok = j.etat();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		j.menu();
		System.out.println();
		System.out.println();
		
		while (ok) {
			try {
				principal();
			}catch(Exception non_entier) {
				System.out.println("veuillez taper un entier s.v.p");
				System.out.println();
			}
		}
	}
	
	public static void principal() {
		
		Scanner sc=new Scanner(System.in);
		while (ok){
			System.out.println("Donner le numéro de l'opération : ");
			int nb=sc.nextInt();            
			sc.nextLine(); 
			j.operation(nb);
			System.out.println();
			System.out.println();
			System.out.println();
			ok=j.etat();
		}
	}
}
