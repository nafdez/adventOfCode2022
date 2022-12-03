package day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Part1_solution {

	public static void main(String[] args) {
		// Variables
		int result = 0;
		int prioraz = 0;
		int priorAZ = 0;
		String c1a = "";
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
	        
	        for(int i=0; i<data.size(); i++) {
	        	// Separando el input en dos
	        	String s1a = data.elementAt(i).substring(0, data.elementAt(i).length()/2);
	        	String s1b = data.elementAt(i).substring(data.elementAt(i).length()/2);
	        	
	        	c1a = String.valueOf(searchInIndex(s1a, s1b));
	        	
	        	// Establecemos prioridades del 1 al 26 para a-z y 27-52 para A-Z
	        	prioraz = az.indexOf(c1a)+1;
	        	priorAZ = AZ.indexOf(c1a)+27;
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
	
	static char searchInIndex(String s1a, String s1b) {
		char c2 = ' ';
		for(int j=0; j<s1b.length(); j++) {
    		try { 
    			c2 = s1b.charAt(s1b.indexOf(s1a.charAt(j)));
    		}catch(StringIndexOutOfBoundsException e) {}
    	}
		return c2;
		
		// Buscando la letra repetida
		// Try/catch porque indexOf si no encuentra nada da -1,
		// y para que no se cague encima y siga buscando
		// en bucle
	}

}
