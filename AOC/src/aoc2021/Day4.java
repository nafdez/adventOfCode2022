package aoc2021;

import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2021/test/day4Input.txt"));
		ArrayList<ArrayList<String>> tempBoard = new ArrayList<>();
		ArrayList<ArrayList<ArrayList<String>>> bingomocho = new ArrayList<>();
		
//		while(sc.hasNextLine()) {
			// parsear los números ganadores
			boardParser(sc, tempBoard);
			bingomocho.add(tempBoard);
//		}
		
		for(int i = 0; i < tempBoard.size(); i++) { // Recorremos el array contenedor de matrices - Vector de matrices
			for(int j = 0; i < tempBoard.get(i).size(); j++) { // Ahora empezamos a recorrer cada una de las tablas - Vector de vectores
				System.out.println(tempBoard.get(i));
			}
		}
		
	}
	
	static void boardParser(Scanner sc, ArrayList<ArrayList<String>> board) {
		ArrayList<String> tempArray = new ArrayList<>();
		while(sc.hasNextLine()) {
			lineBorderParser(sc, tempArray);
			board.add(tempArray);
		}
	}
	
	static void lineBorderParser(Scanner sc, ArrayList<String> line) {
		String temp = sc.nextLine();
		temp = temp.replaceAll(" ", "-").replaceAll("--", "-");
		String[] tempStrArray = temp.split("-");
		for(String i : tempStrArray)
			line.add(i);
	}

}
