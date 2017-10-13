import java.util.Scanner;

import javax.swing.table.TableColumnModel;

public class Tablero {
	int dimension=11;
	String tablero[][]=new String[dimension][dimension];
	
	Utilidades misUtilidades=new Utilidades();

	

	public void LlenarAleatorio(){
	
		int tama�o=0;
		int f =0;
		int c =0;
		int direccion=0 ;

			for (int i = 2; i <= 5; i++) {//camnio 6 a 5
				
				//utilizo el for para asignarun solo barco de cada tama�o
				if (i==2) {//para evitar el barco de tama�o 1;
					tama�o=i;
					
				}else if(i==6) {
					tama�o =i-1;//evitar el barco de tama�o 6
				}else {
					tama�o=i;
				}
				 
				 //(int) (Math.random() * 5) + 1
				 f = misUtilidades.Aleatorio(1, 5) ;//desde 1 a 5 para evitar fuera del talero
				 									//dejando margen de 5 para tama�o de 5 
				 c = misUtilidades.Aleatorio(1, 5);
				 direccion=misUtilidades.Aleatorio(0, 2) ;
				 
				
				 //if tam=5 hacer mas pequ�os
				 boolean localizacionEncontrada=false;
				 
				 while (localizacionEncontrada==false) {
					
					if (ColocarBarcoEnNuevaPos(f,c,tama�o,direccion)) {
						localizacionEncontrada=true;
						System.out.println("Coordenadas "+f+","+c+" direcc: " +direccion+" para barco "+tama�o+" encontrada");
						System.out.println("");
						// System.out.println("localizacion para barco "+tama�o+" encontrada: "+f+","+c+" direcc: " +direccion);
					} else{
						//System.out.println("Localizacion "+f+","+c+"del barco " +tama�o+" y direc:"+ direccion+" no valida \n Buscando nueva"
						//		+ " posicion para barco  de tama�o: "+tama�o);
						
						System.out.println("Coordenadas "+f+","+c+" direcc: " +direccion+" para barco "+tama�o+" no valida ");
						System.out.println("Buscando nuevas coordenadas para barco  de tama�o: "+tama�o+" ...");
						System.out.println("");
						
						f = misUtilidades.Aleatorio(1, 5) ;//desde 1 a 5 para evitar fuera del talero
							//dejando margen de 5 para tama�o de 5 
						c = misUtilidades.Aleatorio(1, 5);
						direccion=misUtilidades.Aleatorio(0, 2) ;
						
						localizacionEncontrada=false;
					}
				}
				 
				 
			}
		
		
		
		
		
	}
	public boolean ColocarBarcoEnNuevaPos(int f,int c,int tama�o, int direccion){
		

		String tipoDebarco="x";
		int distanciaHorizontal=10-c;
		int distanciaVerticall=10-f;
		
		if (tablero[f][c]=="0") {//si la pos inicia no esta ocupada
			
		
			if (direccion==0) {//horizantal
				
				if (distanciaHorizontal+1<tama�o) {
					System.out.println("fuera de limites horizontales");
					System.out.println("");
					return false;
							
				}else{
					
					for (int i =0; i < tama�o; i++) {
						
						if (tablero[f][c+i]!="0") {//si la celda contigua drc hasta el tama�o de barco esta ocupada
							return false;//esa pos no vale
						}
					}
							
					for (int k = 0; k < tama�o; k++) {//a�adimos barco
						//tablero[f+k][c]=tipoDebarco;
						tablero[f][c+k]="1";
					}
							
				}
			}else {//vertical
				
				
				
				
				if (distanciaVerticall+1<tama�o) {
					System.out.println("fuera de limites verticales");
					System.out.println("");
					
					return false;
					
				}else{
					
					for (int i = 0; i <= tama�o; i++) {
						
						if (tablero[f+i][c]!="0") {//si la celda contigua inferior hasta el tama�o de barco esta ocupada
							return false;//esa pos no vale
						}
				
						
					}
					
					for (int i = 0; i < tama�o; i++) {
						
						//tablero[f][c+i]=tipoDebarco;//"1"
						tablero[f+i][c]="1";
					}
				
					
				}
				
			}
		}else {
			System.out.println("Posicion  inicial "+f+","+c+" para barco "+ tama�o+" ocupada");
			
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
	
	/*public  boolean colocarBarco(int f,int c,int tama�o, int direccion){
		

		String tipoDebarco="x";
		int distanciaHorizontal=10-f;
		int distanciaVerticall=10-c;
		
		if (tablero[f][c]=="0") {//si la pos inicia no esta ocupada
			
		
			if (direccion==0) {//horizantal
				
				for (int i =0; i < tama�o; i++) {
					
					if (tablero[f+i][c]!="0") {//si la celda contigua drc hasta el tama�o de barco esta ocupada
						return false;//esa pos no vale
					}
			
					
				}
						
				if (distanciaHorizontal+1<tama�o) {
					System.out.println("fuera de limites horizontales");
					return false;
							
							
				}else{
					if (tama�o==5) {//tipo de barco temporal
						tipoDebarco="D";
					}else if (tama�o==4) {
						tipoDebarco="A";
					}else if (tama�o==3) {
						tipoDebarco="F";
					}else {
						tipoDebarco="M";
					}
							
					for (int k = 0; k < tama�o; k++) {//a�adimos barco
						tablero[f+k][c]="1";
					}
							
				}
			
				
			}else {//vertical
				
				for (int i = 1; i <= tama�o; i++) {
					
					if (tablero[f][c+i]!="0") {//si la celda contigua inferior hasta el tama�o de barco esta ocupada
						return false;//esa pos no vale
					}
			
					
				}
				
				
				if (distanciaVerticall+1<tama�o) {
					System.out.println("fuera de limites verticales");
					
					return false;
					
				}else{
					 if (tama�o==5) {//tipo de barco temporal
						 tipoDebarco="D";
						
						
					}else if (tama�o==4) {
						tipoDebarco="A";
					}else if (tama�o==3) {
						tipoDebarco="F";
					}else {
						tipoDebarco="M";
					}
					for (int i = 0; i < tama�o; i++) {
						
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
