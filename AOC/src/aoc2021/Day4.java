package aoc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
	static int numWinner = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2021/day4Input.txt"));
//		ArrayList<String> winners = new ArrayList<>();
		ArrayList<String[][]> bingomocho = new ArrayList<>();

		// Almacenamos los números ganadores en un string
		String[] winners = sc.nextLine().split(","); // Esto se consigue leyendo la línea y usando ".split()", dando una
														// coma como argumento

		// Almacenamos en un array cada línea de la tabla mediante un bucle, y después
		// añadimos este al array de tablas
		while (sc.hasNextLine()) {
			sc.nextLine();
			String[][] board = new String[5][5];
			for (int i = 0; i < 5; i++) {
				board[i] = boardParser(sc);
			}
			bingomocho.add(board);
		}
		
		String[][] winner = null;
		
		winner = checkWinner(winners, bingomocho);
		
		
		if(winner != null) {
			printArrayList(winner);
			System.out.println("Total score: " + (sumUnchecked(winner)*numWinner));
		} else 
			System.out.println("No se ha encontrado ningún ganador.");
		

	}

	static String[] boardParser(Scanner sc) {
		String numbers = sc.nextLine();
		if (numbers.charAt(0) == '\s')
			numbers = numbers.substring(1);
		numbers = numbers.replaceAll("\s+", " ");
		String[] line = numbers.split(" ");
		return line;
	}

	static String[][] checkWinner(String[] n, ArrayList<String[][]> matrixVector) {
		String[][] winner = null;
		int numWins = 0;
		// Recorre la lista de números ganadores y asigna el valor a "element"
		for (String element : n) {
			winner = recorrerTableros(matrixVector, element, numWins);
			if (winner != null) { // Comprueba si todavía no hay bingo, si lo hay, retorna el tablero ganador
				numWinner = Integer.parseInt(element);
				return winner;
		}
		}
		return null;
	}

	static String[][] recorrerTableros(ArrayList<String[][]> v, String element, int nWins) {
		// Recorre el vector de tableros >> El index de cada tablero es almacenado en
		// "i"
		for (String[][] board : v) {
			// Recorre el tablero >> El index de cada línea es almacenado en "j"
			for (int j = 0; j < board.length; j++) {
				// Recorre las líneas de los tableros >> El index del valor es almacenado en "l"
				for (int l = 0; l < board[j].length; l++) {
					if (checkAndMark(element, board, j, l) && isBingo(board, j, l)) {
						return board; // Si hay bingo, devuelve el número del tablero en el que estaba
					}
						
				}
			}
		}
		return null; // Si no hay bingo, devuelve -1
	}

	static boolean checkAndMark(String element, String[][] board, int posLine, int posValue) {
		if (board[posLine][posValue].equals(element)) {
			board[posLine][posValue] += "*";
			return true;
		}
		return false;
	}

	static boolean isBingo(String[][] board, int f, int c) {
		boolean bingo = false;

		int[][] filasColumnas = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		for (int i = 0; i < board.length; i++) {
			if (board[i][c].matches("\\d+\\*"))
				filasColumnas[1][i] = 1;
		}

		for (int i = 0; i < board[f].length; i++) {
			if (board[f][i].matches("\\d+\\*"))
				filasColumnas[0][i] = 1;
		}
		
		int sumaFilas = 0;
		int sumaColumnas = 0;
		
		for(int i : filasColumnas[0])
			sumaFilas += i;
		
		for(int i : filasColumnas[1])
			sumaColumnas += i;
		
		if (sumaFilas == 5 || sumaColumnas == 5)
			bingo = true;

		return bingo;

	}

	static int sumUnchecked(String[][] board) {
		int suma = 0;
		for (String[] i : board) {
			for (String j : i) {
				if (!j.matches("\\d+\\*"))
					suma += Integer.parseInt(j);
			}
		}
		return suma;
	}

	static void printArrayList(ArrayList<String[][]> a) {
		for (String[][] element : a) {
			for (int j = 0; j < element.length; j++) {
				System.out.println(Arrays.toString(element[j]));
			}
			System.out.println();
		}
	}

	static void printArrayList(String[][] board) {
		for (int j = 0; j < board.length; j++) {
			System.out.println(Arrays.toString(board[j]));
		}
		System.out.println();
	}

}
