import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu j = new Jeu();
		j.mis_a_jour_menu();
		System.out.println();
		System.out.println();

		Scanner sc=new Scanner(System.in);
		while (true){
			System.out.println("Donner le num�ro de l'op�ration : ");
			int nb=sc.nextInt();            
			sc.nextLine(); 
			j.operation(nb);
			System.out.println();
			System.out.println();
			System.out.println();	
		}
	}

}
