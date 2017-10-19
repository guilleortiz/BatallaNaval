import java.util.Scanner;

import javax.swing.table.TableColumnModel;

public class Tablero {

	public Tablero() {
		// TODO Auto-generated constructor stub
	}

	int dimension = 11;
	String tablero[][] = new String[dimension][dimension];

	Utilidades misUtilidades = new Utilidades();

	public void TurnoColocar() {

		Scanner sc = new Scanner(System.in);

		int c , f, tamaño=1, direccion=1;

		for (int i = 2; i <= 5; i++) {// CAMBIO AQUI numero de barcos

			// System.out.println("intriduzca tamaño del barco "+barcos);
			tamaño = i;
			
			
			do {
				System.out.println("introduzca fila del barco " + tamaño);
				f = sc.nextInt();

			} while (misUtilidades.InputValidation(f, 1, 10) == false);

			do {
				System.out.println("introduzca columna del barco " + tamaño);
				c = sc.nextInt();

			} while (misUtilidades.InputValidation(c, 1, 10) == false);

			do {
				System.out.println("introduzca direccion del barco " + tamaño);
				direccion = sc.nextInt();

			} while (misUtilidades.InputValidation(direccion, 1, 2) == false);

			boolean localizacionEncontrada = false;

			while (localizacionEncontrada == false) {

				if (ColocarBarcoEnNuevaPos(f, c, tamaño, direccion)) {
					localizacionEncontrada = true;
					System.out.println("Coordenadas " + f + "," + c + " direcc: "
							+ (direccion == 1 ? "horizontal" : "vertical") + " para barco " + tamaño + " valida");
					System.out.println("");
				} else {
					System.out.println("Coordenadas " + f + "," + c + " direcc: "
							+ (direccion == 1 ? "horizontal" : "vertical") + " para barco " + tamaño + " no valida ");
					System.out.println(" Ingrese nuevas coordenadas para barco  de tamaño: " + tamaño);
					System.out.println("");

					do {
						System.out.println("introduzca fila del barco " + tamaño);
						f = sc.nextInt();

					} while (misUtilidades.InputValidation(f, 1, 10) == false);

					do {
						System.out.println("introduzca columna del barco " + tamaño);
						c = sc.nextInt();

					} while (misUtilidades.InputValidation(c, 1, 10) == false);

					do {
						System.out.println("introduzca direccion del barco " + tamaño);
						direccion = sc.nextInt();

					} while (misUtilidades.InputValidation(direccion, 1, 2) == false);

					localizacionEncontrada = false;
				}
			}

		}

	}

	

	public void LlenarAleatorio() {

		int tamaño = 0;
		int f = 0;
		int c = 0;
		int direccion = 0;

		for (int i = 2; i <= 5; i++) {

			tamaño = i;

			// (int) (Math.random() * 9) + 1
			f = misUtilidades.Aleatorio(1, 9);

			c = misUtilidades.Aleatorio(1, 9);

			direccion = misUtilidades.Aleatorio(1, 2);

			boolean localizacionEncontrada = false;

			while (localizacionEncontrada == false) {

				if (ColocarBarcoEnNuevaPos(f, c, tamaño, direccion)) {
					localizacionEncontrada = true;
					System.out.println("Coordenadas " + f + "," + c + " direcc: "
							+ (direccion == 1 ? "horizontal" : "Vertical") + " para barco " + tamaño + " encontrada");
					System.out.println("");

				} else {

					System.out.println("Coordenadas " + f + "," + c + " direcc: "
							+ (direccion == 1 ? "horizontal" : "Vertical") + " para barco " + tamaño + " no valida ");

					System.out.println("Buscando nuevas coordenadas para barco  de tamaño: " + tamaño + " ...");
					System.out.println("");

					f = misUtilidades.Aleatorio(1, 9);
					c = misUtilidades.Aleatorio(1, 9);
					direccion = misUtilidades.Aleatorio(1, 2);

					localizacionEncontrada = false;
				}
			}

		}

	}

	public boolean ColocarBarcoEnNuevaPos(int f, int c, int tamaño, int direccion) {

		int distanciaHorizontal = 10 - c;
		int distanciaVerticall = 10 - f;

		if (tablero[f][c] == "0") {// si la pos inicia no esta ocupada

			if (direccion == 1) {// horizantal// antes 0

				if (distanciaHorizontal + 1 < tamaño) {
					System.out.println("fuera de limites horizontales");
					System.out.println("");
					return false;

				} else {

					for (int i = 0; i < tamaño; i++) {

						if (tablero[f][c + i] != "0") {// si la celda contigua
														// drc hasta el tamaño
														// de barco esta ocupada
							return false;// esa pos no vale
						}
					}

					for (int k = 0; k < tamaño; k++) {// añadimos barco
						// tablero[f+k][c]=tipoDebarco;
						tablero[f][c + k] = "1";
					}

				}
			} else {// vertical =2

				if (distanciaVerticall + 1 < tamaño) {
					System.out.println("fuera de limites verticales");
					System.out.println("");

					return false;

				} else {

					for (int i = 0; i <= tamaño; i++) {

						if (tablero[f + i][c] != "0") {// si la celda contigua
														// inferior hasta el
														// tamaño de barco esta
														// ocupada
							return false;// esa pos no vale
						}

					}

					for (int i = 0; i < tamaño; i++) {

						// tablero[f][c+i]=tipoDebarco;//"1"
						tablero[f + i][c] = "1";
					}

				}

			}
		} else {
			System.out.println("Posicion  inicial " + f + "," + c + " para barco " + tamaño + " ocupada");

			return false;
		}

		return true;

	}

	public boolean Atacar(int f, int c) {

		if (tablero[f][c] == "1") {
			// System.out.println("TOCADO!");
			tablero[f][c] = "B";
			return true;

		} else {
			// System.out.println("AGUA!");
			tablero[f][c] = "*";
			return false;
		}

	}

	public boolean ExistenBarcos() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == "1") {
					return true;

				}

			}

		}
		return false;

	}

	public void Jugar(int bombas) {

		PintaTablero();

		TurnoAtacar(bombas);

		if (ExistenBarcos()) {

			System.out.println("----------------DERROTA-----------------");
			misUtilidades.refrescarPantalla(8);

		} else {
			// refrescarPantalla(16);
			System.out.println("----------------VICTORIA-----------------");
			misUtilidades.refrescarPantalla(8);

		}

	}

	public void EstadoDePartida(int bombas) {
		System.out.println("Le quedan " + bombas + " bombas disponibles");
		System.out.println("");
	}

	public void TurnoAtacar(int bombas) {
		Scanner sc = new Scanner(System.in);
		int c, f;
		// int bombas=14;

		while (bombas > 0) {
			if (ExistenBarcos()) {

				EstadoDePartida(bombas);
				
				
				do {
					System.out.println("introduzca fila del objetivo a atacar");
					f = sc.nextInt();
					

				} while (misUtilidades.InputValidation(f, 1, 10) == false);
				
				do {
					System.out.println("introduzca columna del objetivoa atacar");
					c = sc.nextInt();
				} while (misUtilidades.InputValidation(c, 1, 10) == false);
			
				
				misUtilidades.refrescarPantalla(16);
				if (Atacar(f, c)) {
					System.out.println(" ------------------------------------------");
					System.out.println("|                  TOCADO!                 |");
					System.out.println(" ------------------------------------------");
				} else {
					System.out.println(" -------------------------------------------");
					System.out.println("|                  AGUA!                    |");
					System.out.println(" -------------------------------------------");
				}
				;
				PintaTablero();

				bombas--;

			} else {
				System.out.println("HAS DESTRUIDO EL ULTIMO BARCO!!");
				bombas = -1;
			}
		}

	}

	public void PintaTablero() {

		System.out.println("     A   B   C   D   F   G   H   I   J   K");

		for (int i = 1; i < tablero.length; i++) {

			if (i == tablero.length - 1) {// cuadramos el ultimo
				System.out.print(i + " ");// cordenadas verticales
			} else {
				System.out.print(i + "  ");// cordenadas verticales
			}

			for (int j = 1; j < tablero.length; j++) {

				if (tablero[i][j] == "0" || tablero[i][j] == "1") {

					System.out.print("|   ");
					// System.out.print("| ");//Contenido de celda

				} else if (tablero[i][j] == "B" || tablero[i][j] == "*") {
					System.out.print("| " + tablero[i][j] + " ");// Contenido de
																	// celda

				}

			}

			System.out.println("|");
			System.out.println("");

		}

	}
	
	public void TrucoMostrarBarcos() {

		System.out.println("     A   B   C   D   F   G   H   I   J   K");

		for (int i = 1; i < tablero.length; i++) {

			if (i == tablero.length - 1) {// cuadramos el ultimo
				System.out.print(i + " ");// cordenadas verticales
			} else {
				System.out.print(i + "  ");// cordenadas verticales
			}

			for (int j = 1; j < tablero.length; j++) {

				if (tablero[i][j] == "0" || tablero[i][j] == "1") {

					System.out.print("| " + /* +" " */tablero[i][j] + " "/* +" " */);
					// System.out.print("| ");//Contenido de celda

				} else if (tablero[i][j] == "B" || tablero[i][j] == "*") {
					System.out.print("| " + tablero[i][j] + " ");// Contenido de
																	// celda

				}

			}

			System.out.println("|");
			System.out.println("");

		}

	}

	public void ResetearTablero() {
		System.out.println("Limpiando tablero...");

		for (int i = 1; i < tablero.length; i++) {// columnas

			for (int j = 1; j < tablero.length; j++) {// filas
				tablero[i][j] = "0";

			}

		}

	}

}
