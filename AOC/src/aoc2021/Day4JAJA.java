package aoc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4JAJA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day4JAJA.class.getResourceAsStream("/2021/day4Input.txt"));
//		ArrayList<String> winners = new ArrayList<>();
		ArrayList<String[][]> bingomocho = new ArrayList<>();

		// Almacenamos los números ganadores en un string
		String[] winners = sc.nextLine().split(","); // Esto se consigue leyendo la línea y usando ".split()", dando una
														// coma como argumento

//		System.out.println(Arrays.toString(winners));
//		System.out.println();

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
//		printArrayList(bingomocho);

		int winner = checkWinner(winners, bingomocho);

		System.out.println("¡¡El ganador es el participante número " + (winner + 1) + "!!");
		printArrayList(winner, bingomocho);

		System.out.println("Total score: " + (sumUnchecked(bingomocho.get(winner)) * 24));

	}

	static String[] boardParser(Scanner sc) {
		String numbers = sc.nextLine();
		if (numbers.charAt(0) == '\s')
			numbers = numbers.substring(1);
		numbers = numbers.replaceAll("\s+", " ");
		String[] line = numbers.split(" ");
		return line;
	}

	static int checkWinner(String[] n, ArrayList<String[][]> matrixVector) {
		int winner = -1;
		// Recorre la lista de números ganadores y asigna el valor a "element"
		for (String element : n) {
			winner = recorrerTablero(matrixVector, element);
			if(winner > -1) // Comprueba si todavía no hay bingo, si lo hay, retorna el tablero ganador
				return winner;
		}
		return -1;
	}

	static int recorrerTablero(ArrayList<String[][]> v, String element) {
		// Recorre el vector de tableros >> El index de cada tablero es almacenado en
		// "i"
		for (int i = 0; i < v.size(); i++) {
			// Recorre el tablero >> El index de cada línea es almacenado en "j"
			for (int j = 0; j < v.get(i).length; j++) {
				// Recorre las líneas de los tableros >> El index del valor es almacenado en "l"
				for (int l = 0; l < v.get(i)[j].length; l++) {
					checkAndMark(v, element, i, j, l);
					if (isBingo(v.get(i)[j]))
						return i; // Si hay bingo, devuelve el número del tablero en el que estaba
				}
			}
		}
		return -1; // Si no hay bingo, devuelve -1
	}

	static void checkAndMark(ArrayList<String[][]> v, String element, int posBoard, int posLine, int posValue) {
		if (v.get(posBoard)[posLine][posValue].equals(element)) {
			v.get(posBoard)[posLine][posValue] += "*";
		}
	}

	static boolean isBingo(String[] line) {
		boolean bingo = false;
		int count = 0;
		for (String i : line) {
			if (i.matches("\\d+\\*"))
				count++;
		}

		if (count == 5)
			bingo = true;

		return bingo;

	}

	static int sumUnchecked(String[][] matrix) {
		int suma = 0;
		for (String[] element : matrix) {
			for (String j : element) {
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

	static void printArrayList(int index, ArrayList<String[][]> a) {
		for (int j = 0; j < a.get(index).length; j++) {
			System.out.println(Arrays.toString(a.get(index)[j]));
		}
		System.out.println();
	}

}
