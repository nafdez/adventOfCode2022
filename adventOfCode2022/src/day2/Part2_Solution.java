package day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/*
 * []Calcular partida ganada
 * []Calcular cuantos puntos da hacer un movimiento
 * []Input txt
 */

public class Part2_Solution {

	public static void main(String[] args) {
		int player1 = 0;
		int player2 = 0;

		// Movements.
		// Example: rock[0] being opponents move
		// Example: rock[1] being your turn
		// index "0" for opponent move and "1" for yours
		char[][] moves = { { 'A', 'X' }, { 'B', 'Y' }, { 'C', 'Z' } };

		try {
			FileInputStream file = new FileInputStream(
					"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day2/Input_test.txt");
			Scanner scanner = new Scanner(file);
			Vector<String> data = new Vector<>();
			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				data.addElement(temp);
			}

			calcularMoves(data, moves, player1, player2);
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int calcularMoves(Vector<String> d, char[][] m, int p1, int p2) {
		boolean seguir = true;
		int c = -1;
		String turn = "";

		while (seguir) {
			int opM = 0;
			int elfM = 0;
			int x = 0;
			if (c < d.size() - 1) {
				c++;
				turn = d.elementAt(c);
				System.out.println(turn);
			} else if (c >= d.size() - 1) {
				seguir = false;
				return -1;
			}

			char op = turn.charAt(x);
			x += 2;
			char elf = turn.charAt(x);

			opM = buscarChar(m, op, 0); // Busca qué movimiento hizo, y le asigna puntuación
			p1 += opM; // Guardamos estos puntos para sumar más tarde si gana o pierde
			elfM = buscarChar(m, elf, 0);
			p2 += opM;

			switch (elf) {
			case ('X'): // lose
				p2 += 0;
				break;
			case ('Y'): // draw
				p2 += 3;
				break;
			case ('Z'): // win
				p2 += 6;
				break;
			}

			if (opM == elfM + 1 || opM == elfM - 2) {
				p1 += 6; // Gana Opponent
			} else if (elfM == opM) {
				p1 += 3; // Empate
			}

			System.out.println("p1: " + p1 + " p2: " + p2 + " c: " + c);

		}
		return -1;
	}

	static void winOrLose(int opM, int elfM, int p1, int p2) {

	}

	static int buscarChar(char[][] m, char p, int pos) {
		for (int i = 0; i < 3; i++) {
			if (p == m[i][pos]) {
				return i + 1;
			}
		}
		return -1;
	}

}
