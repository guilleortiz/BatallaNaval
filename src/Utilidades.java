import java.util.Scanner;

public class Utilidades {

	public Utilidades() {
		// TODO Auto-generated constructor stub
	}

	public int Aleatorio(int min, int max) {

		return (int) (Math.random() * max) + min;
	}

	public void refrescarPantalla(int t) {
		for (int i = 0; i < t; i++) {
			System.out.println();
		}
	}
	
	public void MenuPrincipal(){
		
		
		
		System.out.println("              _____________________________");
		System.out.println("                                           |            _         ______ |");
		System.out.println("                                           |          /   |___-=O`/|O`/__|");
		System.out.println("                    Guillermo Ortiz        |_________|          / | /    )");
		System.out.println("                                           |           `/-==__ _/__|/__=-|  ");
		System.out.println("                                           |          (o)             |  |");
		System.out.println("              _____________________________|                         (o)	");
		System.out.println("		                           ");
		System.out.println("	                                          ");

		System.out.println("	                ____        _   _       _     _     _     ");
		System.out.println("	               |  _ |      | | | |     | |   | |   (_)   ");
		System.out.println("	               | |_) | __ _| |_| |_ ___| |___| |__  _ _ __  ");
		System.out.println("	               |  _ < / _` | __| __/ _ | | __| '_  | | '_ |       _  _        ");
		System.out.println("	               | _ ( ) (_| | |_| ||  __/ |__ | | | | | |_) |     ( `   )_     ");
		System.out.println("	               |(  _   )  _| __| __|___|_|___/_| |_|_| .__/     (    )    `)  ");
		System.out.println("	               (_  _(_ ,)   --------JUGAR-------     | |       (_   (_ .  _) _)");
		System.out.println("	              (_         ) | 1.Barcos aleatorios  |  |_|    ");
		System.out.println("  	            (__        _)  | 2.Seleccion de Barcos|         ");
		System.out.println(" 	                           | 5.Salir              |         ");
		System.out.println("                         	    ----------------------			");
		System.out.println("                                 .--._            ");
		System.out.println("                         |~:'--~'      |           ");
		System.out.println("                         |~ : _  .--._|          ");
		System.out.println("                     ____|____                      ");
		System.out.println("                __ /---------|                     ");
		System.out.println("              _/__[ ]    _|__|___      //   //       ");
		System.out.println("   _..._____/__________________|_|_,-_//___//_  ");
		System.out.println( "/     o o   o    o        o        o     |.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ ");
		System.out.println(")`'-.___)`'-.,__________)`'-.,_______)`'-., _/ .,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ ");
		System.out.println(" )`'-.,_)`'-.,_)`'-.,_)`'-..,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-. ");
		System.out.println(",_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ .,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-. ");
		
		//refrescarPantalla(10);
		java.awt.Toolkit.getDefaultToolkit().beep(); 
		
		
	}
	
	public int MenuDificultad(){
		
		int dificultad;

		
			System.out.println("              _____________________________");
			System.out.println("                                           |            _         ______ |");
			System.out.println("                                           |          /   |___-=O`/|O`/__|");
			System.out.println("                    Guillermo Ortiz        |_________|          / | /    )");
			System.out.println("                                           |           `/-==__ _/__|/__=-|  ");
			System.out.println("                                           |          (o)             |  |");
			System.out.println("              _____________________________|                         (o)	");
			System.out.println("		                           ");
			System.out.println("	                                          ");

			System.out.println("	                ____        _   _       _     _     _     ");
			System.out.println("	               |  _ |      | | | |     | |   | |   (_)   ");
			System.out.println("	               | |_) | __ _| |_| |_ ___| |___| |__  _ _ __  ");
			System.out.println("	               |  _ < / _` | __| __/ _ | | __| '_  | | '_ |       _  _        ");
			System.out.println("	               | _ ( ) (_| | |_| ||  __/ |__ | | | | | |_) |     ( `   )_     ");
			System.out.println("	               |(  _   )  _| __| __|___|_|___/_| |_|_| .__/     (    )    `)  ");
			System.out.println("	               (_  _(_ ,)   -----DIFICULTAD-----   | |       (_   (_ .  _) _)");
			System.out.println("	              (_         ) | 1.Baja (50 bombs)  |  |_|    ");
			System.out.println("  	            (__        _)  | 2.Media(35 bombas) |         ");
			System.out.println(" 	                           | 3.Alta(22 bombas)  |         ");
			System.out.println("                         	    --------------------			");
			System.out.println("                                 .--._            ");
			System.out.println("                         |~:'--~'      |           ");
			System.out.println("                         |~ : _  .--._|          ");
			System.out.println("                     ____|____                      ");
			System.out.println("                __ /---------|                     ");
			System.out.println("              _/__[ ]    _|__|___      //   //       ");
			System.out.println("   _..._____/__________________|_|_,-_//___//_  ");
			System.out.println( "/     o o   o    o        o        o     |.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ ");
			System.out.println(")`'-.___)`'-.,__________)`'-.,_______)`'-., _/ .,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ ");
			System.out.println(" )`'-.,_)`'-.,_)`'-.,_)`'-..,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-. ");
			System.out.println(",_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_ .,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-.,_)`'-. ");
			
		// refrescarPantalla(10);
		java.awt.Toolkit.getDefaultToolkit().beep();

		Scanner sc = new Scanner(System.in);

		dificultad = sc.nextInt();

		refrescarPantalla(40);
		// miTablero.ResetearTablero();

		switch (dificultad) {
		case 1:
			dificultad = 50;
			break;

		case 2:
			dificultad = 35;
			break;

		case 3:
			dificultad = 22;
			break;

		default:
			System.out.println("Opcion incorrecta");
			break;
		}

		return dificultad;

	}

	public boolean InputValidation(int valor, int min, int max) {

		if (valor >= min && valor <= max) {
			return true;

		} else {
			return false;

		}

	}

}
