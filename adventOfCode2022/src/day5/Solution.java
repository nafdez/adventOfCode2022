package day5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

// Separar Input, cargo, de Input Movimientos

public class Solution {

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
					"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day5/Input_moves_test.txt");

			Scanner sc = new Scanner(f);

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
				cargo = moveCargo(moves.elementAt(i), froms.elementAt(i) - 1, tos.elementAt(i) - 1, cargo);

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

		int cambios = 0;

		// Deepuración
//		System.out.println("////////Antes////////");
//		System.out.println((m)+" from "+(f+1)+Arrays.toString(c[f]));
//		System.out.println("to "+(t+1)+Arrays.toString(c[t]));
		/*********************************************************/

		do {
			int cont = 0;

			while (c[t][cont] != ' ')
				cont++;

			int pos = findLastOcupped(f, c);

			c[t][cont] = c[f][pos];
			c[f][pos] = ' ';

			cambios++;

		} while (cambios < m);

		// Depuración
//		System.out.println("\n////////Después////////");
//		System.out.println("from "+(f+1)+Arrays.toString(c[f]));
//		System.out.println("to "+(t+1)+Arrays.toString(c[t]));
//		System.out.println();
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

}
