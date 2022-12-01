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

public class Part1_Solution {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			FileInputStream file = new FileInputStream("C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day1/part1_Input.txt");
	        Scanner scanner = new Scanner(file);
	        Vector<String> data = new Vector<String>();
	        while (scanner.hasNextLine()){
	        	String temp = scanner.nextLine();
	        	data.addElement(temp);
	        }
	        scanner.close();
	        
	        int[] resultado = insercionDirecta(elfsSum(data));
	        System.out.println("El elfo con más calorías es: "+resultado[resultado.length-1]);

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
	
}
