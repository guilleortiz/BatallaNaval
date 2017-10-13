import java.util.Scanner;

import javax.swing.table.TableColumnModel;

public class Tablero {
	int dimension=11;
	String tablero[][]=new String[dimension][dimension];
	
	Utilidades misUtilidades=new Utilidades();

	

	public void LlenarAleatorio(){
	
		int tamaño=0;
		int f =0;
		int c =0;
		int direccion=0 ;

			for (int i = 2; i <= 5; i++) {//camnio 6 a 5
				
				//utilizo el for para asignarun solo barco de cada tamaño
				if (i==2) {//para evitar el barco de tamaño 1;
					tamaño=i;
					
				}else if(i==6) {
					tamaño =i-1;//evitar el barco de tamaño 6
				}else {
					tamaño=i;
				}
				 
				 //(int) (Math.random() * 5) + 1
				 f = misUtilidades.Aleatorio(1, 5) ;//desde 1 a 5 para evitar fuera del talero
				 									//dejando margen de 5 para tamaño de 5 
				 c = misUtilidades.Aleatorio(1, 5);
				 direccion=misUtilidades.Aleatorio(0, 2) ;
				 
				
				 //if tam=5 hacer mas pequños
				 boolean localizacionEncontrada=false;
				 
				 while (localizacionEncontrada==false) {
					
					if (ColocarBarcoEnNuevaPos(f,c,tamaño,direccion)) {
						localizacionEncontrada=true;
						System.out.println("Coordenadas "+f+","+c+" direcc: " +direccion+" para barco "+tamaño+" encontrada");
						System.out.println("");
						// System.out.println("localizacion para barco "+tamaño+" encontrada: "+f+","+c+" direcc: " +direccion);
					} else{
						//System.out.println("Localizacion "+f+","+c+"del barco " +tamaño+" y direc:"+ direccion+" no valida \n Buscando nueva"
						//		+ " posicion para barco  de tamaño: "+tamaño);
						
						System.out.println("Coordenadas "+f+","+c+" direcc: " +direccion+" para barco "+tamaño+" no valida ");
						System.out.println("Buscando nuevas coordenadas para barco  de tamaño: "+tamaño+" ...");
						System.out.println("");
						
						f = misUtilidades.Aleatorio(1, 5) ;//desde 1 a 5 para evitar fuera del talero
							//dejando margen de 5 para tamaño de 5 
						c = misUtilidades.Aleatorio(1, 5);
						direccion=misUtilidades.Aleatorio(0, 2) ;
						
						localizacionEncontrada=false;
					}
				}
				 
				 
			}
		
		
		
		
		
	}
	public boolean ColocarBarcoEnNuevaPos(int f,int c,int tamaño, int direccion){
		

		String tipoDebarco="x";
		int distanciaHorizontal=10-c;
		int distanciaVerticall=10-f;
		
		if (tablero[f][c]=="0") {//si la pos inicia no esta ocupada
			
		
			if (direccion==0) {//horizantal
				
				if (distanciaHorizontal+1<tamaño) {
					System.out.println("fuera de limites horizontales");
					System.out.println("");
					return false;
							
				}else{
					
					for (int i =0; i < tamaño; i++) {
						
						if (tablero[f][c+i]!="0") {//si la celda contigua drc hasta el tamaño de barco esta ocupada
							return false;//esa pos no vale
						}
					}
							
					for (int k = 0; k < tamaño; k++) {//añadimos barco
						//tablero[f+k][c]=tipoDebarco;
						tablero[f][c+k]="1";
					}
							
				}
			}else {//vertical
				
				
				
				
				if (distanciaVerticall+1<tamaño) {
					System.out.println("fuera de limites verticales");
					System.out.println("");
					
					return false;
					
				}else{
					
					for (int i = 0; i <= tamaño; i++) {
						
						if (tablero[f+i][c]!="0") {//si la celda contigua inferior hasta el tamaño de barco esta ocupada
							return false;//esa pos no vale
						}
				
						
					}
					
					for (int i = 0; i < tamaño; i++) {
						
						//tablero[f][c+i]=tipoDebarco;//"1"
						tablero[f+i][c]="1";
					}
				
					
				}
				
			}
		}else {
			System.out.println("Posicion  inicial "+f+","+c+" para barco "+ tamaño+" ocupada");
			
			return false;
		}
			
			return true;
		
		
	}
	
	public boolean  Atacar(int f,int c){

		
		
		if (tablero[f][c]=="1") {
			//System.out.println("TOCADO!");
			tablero[f][c]="B";
			return true;
			
		}else{
			//System.out.println("AGUA!");
			tablero[f][c]="*";
			return false;
		}
		
		
	}
	public  boolean ExistenBarcos(){
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j]=="1") {
					return true;
					
				}
				
			}
			
		}
		return false;
		 
	}
	
	/*public  boolean colocarBarco(int f,int c,int tamaño, int direccion){
		

		String tipoDebarco="x";
		int distanciaHorizontal=10-f;
		int distanciaVerticall=10-c;
		
		if (tablero[f][c]=="0") {//si la pos inicia no esta ocupada
			
		
			if (direccion==0) {//horizantal
				
				for (int i =0; i < tamaño; i++) {
					
					if (tablero[f+i][c]!="0") {//si la celda contigua drc hasta el tamaño de barco esta ocupada
						return false;//esa pos no vale
					}
			
					
				}
						
				if (distanciaHorizontal+1<tamaño) {
					System.out.println("fuera de limites horizontales");
					return false;
							
							
				}else{
					if (tamaño==5) {//tipo de barco temporal
						tipoDebarco="D";
					}else if (tamaño==4) {
						tipoDebarco="A";
					}else if (tamaño==3) {
						tipoDebarco="F";
					}else {
						tipoDebarco="M";
					}
							
					for (int k = 0; k < tamaño; k++) {//añadimos barco
						tablero[f+k][c]="1";
					}
							
				}
			
				
			}else {//vertical
				
				for (int i = 1; i <= tamaño; i++) {
					
					if (tablero[f][c+i]!="0") {//si la celda contigua inferior hasta el tamaño de barco esta ocupada
						return false;//esa pos no vale
					}
			
					
				}
				
				
				if (distanciaVerticall+1<tamaño) {
					System.out.println("fuera de limites verticales");
					
					return false;
					
				}else{
					 if (tamaño==5) {//tipo de barco temporal
						 tipoDebarco="D";
						
						
					}else if (tamaño==4) {
						tipoDebarco="A";
					}else if (tamaño==3) {
						tipoDebarco="F";
					}else {
						tipoDebarco="M";
					}
					for (int i = 0; i < tamaño; i++) {
						
						tablero[f][c+i]="1";
					}
					
				}
				
			}
		}else {
			System.out.println("posicion  inicial ocupada");
			return false;
		}
			
			return true;
		
		
	}*/
	
	public  void PintaTablero(){
		
	
		
		System.out.println("     A   B   C   D   F   G   H   I   J   K");
		
		for (int i = 1; i < tablero.length; i++) {
			
			if (i==tablero.length-1) {//cuadramos el ultimo
				System.out.print(i+" ");//cordenadas verticales
			}else{
				System.out.print(i+"  ");//cordenadas verticales
			}
					
			for (int j = 1; j < tablero.length; j++) {
				
				if (tablero[i][j]=="0" || tablero[i][j]=="1") {
					System.out.print("| "+/*+" "*/tablero[i][j]+" "/*+" "*/);
					
					//System.out.print("|   ");//Contenido de celda
					
					
				}else if (tablero[i][j]=="B" || tablero[i][j]=="*") {
					System.out.print("| "+tablero[i][j]+" ");//Contenido de celda
					
				}
					
			}
			
			System.out.println("|");
			System.out.println("");
					
		}
		
	}
	
	public  void ResetearTablero(){
		System.out.println("Limpiando tablero...");
		
		for (int i = 1; i < tablero.length; i++) {//columnas
		
			for (int j = 1; j < tablero.length; j++) {//filas
				tablero[i][j]="0";
					
			}
				
		}
		
	}

}
