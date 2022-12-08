package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Solution_Part1 {
	
	static int markSize = 14; // Cambiar según el tamaño del paquete de datos
	static int contador = 0;
	static int pos = markSize-1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Introduzca el tamaño del marcador del paquete de datos: ");
		markSize = Integer.valueOf(in.readLine());
		System.out.println();
		
		FileInputStream f = new FileInputStream("/home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day6/Input.txt");
		Scanner sc = new Scanner(f);
		
		Vector<Character> stream = new Vector<>();
		
		char[] marca = new char[markSize];
		boolean isMark = false;
		boolean error = false;
		int c = 0;
		
		while(sc.hasNext()) {
			stream = parser(sc, stream, "");
		}
		
		while(!isMark&&!error) {
			try {
				for(int j=0; j<markSize; j++) {
					marca[j] = stream.elementAt(c+j);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("No se ha encontrado nada.");
				error=true;
			}
			
			isMark = isMarker(marca);
			c++;
			pos++;
		}
		
		System.out.println("El paquete de datos empieza en la posición nº: "+pos);
		
		sc.close();
		
		
		
	}
	
	static Vector<Character> parser(Scanner sc, Vector<Character> v, String regex) {
		String temp = "";

		try {
			sc.skip(regex);
			temp = sc.next();
			for(int i=0; i<temp.length(); i++)
				v.addElement(temp.charAt(i));;
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return v;
	}
	
	static boolean isMarker(char[] m) {
		String aux1 = "";
		String aux2 = "";
		int c = 0;
		for(int i=0; i<m.length; i++) {
			aux1 = String.valueOf(m[i]);
			aux2 = "";
			for(int j=0; j<markSize; j++) {
				if(j==i) {
					j++;
				}
				try {
					aux2 += m[j];
				} catch (ArrayIndexOutOfBoundsException e) {}
				
			}
			
			if((aux2.contains(aux1)))
				c++;
		}
		if(c>0)
			return false;
		
		return true;
	}
	
	static void printChar(char[] m) {
		for(int i=0; i<m.length; i++)
			System.out.print(m[i]);
	}

}
