import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		int bombas;
		
		Tablero miTablero=new Tablero();
		Utilidades misUtilidades=new Utilidades();
		
		
		misUtilidades.refrescarPantalla(10);
		
		do {
	

			misUtilidades.MenuPrincipal();
			
			opcion=sc.nextInt();
			
			misUtilidades.refrescarPantalla(40);
			miTablero.ResetearTablero();
			
			switch (opcion) {
			case 1:
				bombas=misUtilidades.MenuDificultad();
				miTablero.LlenarAleatorio();
				miTablero.Jugar(bombas);
				break;
				
			case 2:
				bombas=misUtilidades.MenuDificultad();
				miTablero.TurnoColocar();
				miTablero.Jugar(bombas);
				break;
				
			case 3:
	
				break;

			default:
				break;
			}
			
		} while (opcion!=5);

		

	}
	

	
	
	

	


}
