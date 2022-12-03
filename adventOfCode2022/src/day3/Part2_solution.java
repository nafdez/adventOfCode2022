package day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Part2_solution {

	public static void main(String[] args) {
		// Variables
		String[] hvStr = new String[3];
		int cAux = 0;
		int result = 0;
		int prioraz = 0;
		int priorAZ = 0;
		String badge = "";
		String az = "";
		String AZ = "";
		
		
		// Proceso
		try{
			FileInputStream file = new FileInputStream("C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day3/Input.txt");
	        Scanner scanner = new Scanner(file);
	        Vector<String> data = new Vector<String>();
	        while (scanner.hasNextLine()){
	        	String temp = scanner.nextLine();
	        	data.addElement(temp);
	        }
	        
	        // Asignando a az todo el abecedario, y lo mismo con AZ
	        for(char c = 'a'; c <= 'z'; ++c)
	            az+=c;
	        for(char c = 'A'; c <= 'Z'; ++c)
	            AZ+=c;
	        
	     // Separando el input en dos
	        for(int i=0; i<data.size(); i=i+3) {
	        	for(int j=0; j<3; j++) 
	        		hvStr[j] = data.elementAt(cAux++);

	        	String c1a = String.valueOf(searchInIndex(hvStr[0], hvStr[1]));
	        	badge = String.valueOf(searchInIndex(c1a, hvStr[2])[0]); // index 0, porque puede que la común se repita
	        	
	        	System.out.println(badge);
	        	// Establecemos prioridades del 1 al 26 para a-z y 27-52 para A-Z
	        	prioraz = az.indexOf(badge)+1;
	        	priorAZ = AZ.indexOf(badge)+27;
	        	if(priorAZ==26) // Como le sumamos 27, para hacerlo más fácil si el resultado da 26, será 0
	        		priorAZ=0;
	        	result += prioraz + priorAZ;
	        }
	        
	        scanner.close();
		} catch(IOException e){
	        e.printStackTrace();
	      }
		
		System.out.println("La suma de todos lo items es: " + result);

	}
	
	static String[][] stringGroups(Vector <String> data, String[][] strAux, int i, int j) {
		strAux[j][0] = data.elementAt(i).substring(0, data.elementAt(i).length()/2);
    	strAux[j][1] = data.elementAt(i).substring(data.elementAt(i).length()/2);
		return strAux;
	}
	
	static char[] searchInIndex(String str01, String str02) {
		// Evaluo cual string es más largo para que c2 no se quede sin espacio nunca
		// Dado el caso que si los 2 string son iguales, c2 se llenaría muy rápido
		int l = str02.length();
		if(str01.length()>str02.length())
			l = str01.length();
		// Función principal
		char c2[] = new char[l];
		int c = 0;
		for(int j=0; j<str02.length(); j++) {
    		try { 
    			c2[c++] = str01.charAt(str01.indexOf(str02.charAt(j)));
    		}catch(StringIndexOutOfBoundsException e) {c--;}
    	}
		return c2;
		
		// Buscando la letra repetida
		// Try/catch porque indexOf si no encuentra nada da -1,
		// y para que no se cague encima y siga buscando
		// en bucle
	}

}