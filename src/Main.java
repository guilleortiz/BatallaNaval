import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		Tablero miTablero=new Tablero();
		
		
		refrescarPantalla(10);
		
		do {
	

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
			
			/*
			System.out.println("         ----------HUNDIR LA FLOTA--------- ");
			System.out.println("        |                                  |");
			System.out.println("        |        1.Barcos aleatorios       |");
			System.out.println("        |        2.Seleccion de Barcos     |");
			System.out.println("        |        5.Salir                   |");
			System.out.println("        |                                  |");
			System.out.println("         ---------------------------------- ");
			*/
			
			//refrescarPantalla(10);
			java.awt.Toolkit.getDefaultToolkit().beep(); 
			opcion=sc.nextInt();
			refrescarPantalla(40);
			miTablero.ResetearTablero();
			
			switch (opcion) {
			case 1:
				
				miTablero.LlenarAleatorio();
				Jugar(miTablero);
				break;
			case 2:
				TurnoColocar(miTablero);
				Jugar(miTablero);
				break;
			case 3:
	
				break;

			default:
				break;
			}
			
		} while (opcion!=5);

		

		//
		

		
		
		
		
	
		

	}
	
	public static void Jugar(Tablero miTablero){
		//miTablero.ResetearTablero();
		miTablero.PintaTablero();
		
		TurnoAtacar(miTablero);
		
		if (miTablero.ExistenBarcos()) {
			
			System.out.println("----------------DERROTA-----------------");
			refrescarPantalla(8);
			
		}else {
			//refrescarPantalla(16);
			System.out.println("----------------VICTORIA-----------------");
			refrescarPantalla(8);
						
		}
		
	}

	public static void EstadoDePartida(int bombas){
		System.out.println("Le quedan "+bombas+" bombas disponibles");
		System.out.println("");
	}

	public static void TurnoAtacar(Tablero miTablero){
		Scanner sc = new Scanner(System.in);
		int c,f;
		int bombas=14;
		
		
		while (bombas>0) {
			if (miTablero.ExistenBarcos()) {
				
				EstadoDePartida(bombas);
				System.out.println("introduzca fila del objetivo a atacar");
				f=sc.nextInt();
				
				System.out.println("introduzca columna del objetivoa atacar");
				c=sc.nextInt();
				
				refrescarPantalla(16);
				if(miTablero.Atacar(f, c)){
					System.out.println(" ------------------------------------------");
					System.out.println("|                  TOCADO!                 |");
					System.out.println(" ------------------------------------------");
				}else{
					System.out.println(" -------------------------------------------");
					System.out.println("|                  AGUA!                    |");
					System.out.println(" -------------------------------------------");
				}
				;
				miTablero.PintaTablero();
				
				bombas--;
				
				
			}else {
				System.out.println("HAS DESTRUIDO EL ULTIMO BARCO!!");
				bombas=-1;
			}
		}
	
		
		
	}
	
	public static void TurnoColocar(Tablero miTablero){

		Scanner sc = new Scanner(System.in);
		
		
		int c,f,tamaño,direccion;
		
		for (int i = 2; i <=2; i++) {//CAMBIO AQUI!!!!!!!!!!!!!!!!!
			
			//System.out.println("intriduzca tamaño del barco "+barcos);
			 tamaño=i;
			
			System.out.println("introduzca fila del barco "+tamaño);
			 f=sc.nextInt();
			
			System.out.println("intriduzca c del barco "+tamaño);
			 c=sc.nextInt();
			
			
			
			System.out.println("intriduzca dire del barco "+tamaño);
			 direccion=sc.nextInt();
			 
			 boolean localizacionEncontrada=false;
			 
			 while (localizacionEncontrada==false) {
					
					if (miTablero.ColocarBarcoEnNuevaPos(f,c,tamaño,direccion)) {
						localizacionEncontrada=true;
						 System.out.println("localizacion "+f+","+c+" direcc: " +direccion+" para barco "+tamaño+" valida");
						 System.out.println("");
					} else{
						System.out.println("Coordenadas "+f+","+c+" direcc: " +direccion+" para barco "+tamaño+" no valida ");
						System.out.println(" Ingrese nuevas coordenadas para barco  de tamaño: "+tamaño);
						System.out.println("");
						
						System.out.println("introduzca fila del barco "+tamaño);
						 f=sc.nextInt();
						
						System.out.println("intriduzca c del barco "+tamaño);
						 c=sc.nextInt();
						
						System.out.println("intriduzca dire del barco "+tamaño);
						 direccion=sc.nextInt();
						
						localizacionEncontrada=false;
					}
				}
			 
			
		}
		
		
		
		
		
	}
	
	
	public static void refrescarPantalla(int t){
		 for (int i=0; i < t; i++){
			 System.out.println();
		 }
	 }
	

	


}
