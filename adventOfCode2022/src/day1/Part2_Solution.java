package day1;

// Linux
// /home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day1/part1_Input.txt
// Windows
// C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day1/part1_Input.txt

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Part2_Solution {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			FileInputStream file = new FileInputStream("/home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day2/Input_test.txt");
	        Scanner scanner = new Scanner(file);
	        Vector<String> data = new Vector<String>();
	        while (scanner.hasNextLine()){
	        	String temp = scanner.nextLine();
	        	data.addElement(temp);
	        }
	        scanner.close();
	        
	        int[] resultado = insercionDirecta(elfsSum(data));
	        System.out.println("Los elfos con más calorías son:\n1. "+resultado[resultado.length-1]);
	        System.out.println("2. "+resultado[resultado.length-2]);
	        System.out.println("3. "+resultado[resultado.length-3]);
	        
	        System.out.println("\nLa suma de los tres elfos con más calorias es: "+sumaPrimeros(resultado));

		} catch(IOException e){
	        e.printStackTrace();
	      }
		
		
		
	}
	
	static int[] elfsSum(Vector<String> v) {
		int suma=0;
		int[] result = new int[v.size()];
		boolean fin = false;
		int c=0;
		int x=0;
		
		do {
			if(v.elementAt(c)!="" && c<=v.size()-1) {
				suma += Integer.parseInt(v.elementAt(c++));
			}
			if (v.elementAt(c)=="" && c<=v.size()-1) {
				result[x] = suma;
				x++;
				c++;
				suma = 0;
			} else if(c>=v.size()-1){
				fin = true;
			}
		}while(!fin);
		
		return result;
	
	}
	
	static int[] insercionDirecta(int [] v) {
		for (int i=1; i<v.length; i++) {
			int j = 0;
			while (j < i && v[j] < v[i])
				j++;
			if (j < i) {
				int aux = v[i];
				for (int k=i-1; k>=j; k--)
					v[k+1] = v[k];
				v[j] = aux;
			}
		}
		return v;
	}
	
	/**********
	 * PARTE 2
	 **********/
	
	static int sumaPrimeros(int[] v) {
		int suma = 0;
		for(int i=v.length-1; i>=v.length-3; i--) {
			suma = suma + v[i];
		}
		return suma;
	}
	
}