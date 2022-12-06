package day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class ParsedVersion {

	public static void main(String[] args) {
		char[][] cargo = 
							  {{'Z','N',' ',' ',' ',' '},{'M','C','D',' ',' ',' '},{'P',' ',' ',' ',' ',' '}};
							 
					/*{ { 'F', 'T', 'C', 'L', 'R', 'P', 'G', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
						' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
						' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
						{ 'N', 'Q', 'H', 'W', 'R', 'F', 'S', 'J', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'F', 'B', 'H', 'W', 'P', 'M', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'V', 'S', 'T', 'D', 'F', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'Q', 'L', 'D', 'W', 'V', 'F', 'Z', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'Z', 'C', 'L', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'Z', 'B', 'M', 'V', 'D', 'F', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'T', 'J', 'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' },
						{ 'Q', 'N', 'B', 'G', 'L', 'S', 'P', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
								' ', ' ', ' ' } };*/

		try {
				FileInputStream f = new FileInputStream(
						"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day5/test/Input_moves.txt");
			Scanner sc = new Scanner(f);
			
			FileInputStream fC = new FileInputStream(
					"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day5/test/Input_cargo.txt");
			Scanner scCrg = new Scanner(fC);

			Vector<String> data = new Vector<>();
			while(scCrg.hasNextLine()) {
				data = cargoParser(scCrg, data, "");
				}
			
			for(int i = 0; i<data.size(); i++)
				System.out.println(data.elementAt(i));
			
			char[][] crg = new char[data.size()-1][data.size()*2];
			
			int cont = 0;
			int y = data.size()-2;

			for(int i=0; i<crg.length; i++) {
					cont = 0;
					for(int x=0; x<data.elementAt(x).length(); x++) {
						try {
							crg[cont++][i] = data.elementAt(y).charAt(x);
						} catch (StringIndexOutOfBoundsException e) {
							crg[cont++][i] = '-';
						}
					}
					y--;
			}
			
				
		
			mostrarMatriz(crg);

			Vector<Integer> moves = new Vector<>();
			Vector<Integer> froms = new Vector<>();
			Vector<Integer> tos = new Vector<>();

			while (sc.hasNextLine()) {
				moves = parser(sc, moves, "move ");
				froms = parser(sc, froms, " from ");
				tos = parser(sc, tos, " to ");
				try {
					sc.nextLine();
				} catch (NoSuchElementException e) {
					System.out.print(e);
				}

			}

			for (int i = 0; i < moves.size(); i++)
				cargo = moveCargo(moves.elementAt(i), froms.elementAt(i) - 1, tos.elementAt(i) - 1, crg);

			String result = "";
			for (int i = 0; i < cargo.length; i++)
				result += cargo[i][findLastOcupped(i, cargo)];

			mostrarMatriz(cargo);
			System.out.println("El resultado es " + result);

			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// {{'Z','N',' '},{'M','C','D'},{'P',' ',' '}};
	// 1 2 3
	static char[][] moveCargo(int m, int f, int t, char[][] c) {
		// Depuración
		System.out.println("////////Antes////////");
		System.out.println((m)+" from "+(f+1)+Arrays.toString(c[f]));
		System.out.println("to "+(t+1)+Arrays.toString(c[t]));
		/*********************************************************/

		int cont = 0;

		while (c[t][cont] != ' ')
				cont++;

		int pos = findLastOcupped(f, c);
		
		for(int i=m; i>0; i--) {
			c[t][cont+(i-1)] = c[f][pos];
			c[f][pos--] = ' ';
		}
		
		// Depuración
		System.out.println("\n////////Después////////");
		System.out.println("from "+(f+1)+Arrays.toString(c[f]));
		System.out.println("to "+(t+1)+Arrays.toString(c[t]));
		System.out.println();
		/*********************************************************/
		return c;
	}

	static int findLastOcupped(int f, char[][] c) {
		int i = c[f].length - 1;

		while (c[f][i] == ' ') {
			i--;
		}

		return i;

	}

	static void mostrarMatriz(char[][] m) {
		System.out.println();
		for (int i = 0; i < m.length; i++) {
			System.out.print((i + 1) + "[");
			System.out.print(m[i]);
			System.out.print("]\n");
		}
		System.out.println();
	}
	
	static void mostrarMatriz(String[][] m) {
		System.out.println();
		for (int i = 0; i < m.length; i++) {
//			System.out.print((i + 1) + "[");
			System.out.print(Arrays.toString(m[i]));
//			System.out.print("]\n");
			System.out.println();
		}
		System.out.println();
	}

	static Vector<Integer> parser(Scanner sc, Vector<Integer> v, String regex) {
		int temp = 0;

		try {
			sc.skip(regex);
			temp = sc.nextInt();
			v.add(temp);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return v;
	}
	
	static Vector<String> cargoParser(Scanner sc, Vector<String> v, String regex) {
		try {
			sc.skip(regex); // No sirve pa na, lo dejo por si me sirviera para poder leer de un solo archivo todo el input
			String temp = sc.nextLine().replaceAll("    ", "-").replaceAll("[\\[\\]]", "").replaceAll(" ", "").replaceAll("-", " ");
			v.add(temp);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return v;
	}
}
