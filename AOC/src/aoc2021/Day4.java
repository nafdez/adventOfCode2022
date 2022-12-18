package aoc2021;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

	public static void main(String[] args) {
		Pattern pOnlyNumbers = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)");
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2021/test/day4Input.txt"));
		
		Pattern pBoards = Pattern.compile("((\\d+\\s+){4}\\d+\\s*){5}");
		ArrayList<String[][]> bingomocho = new ArrayList<>();
		while(sc.hasNext(pBoards)) {
			System.out.println("hola");
			bingomocho.add(boardParser(sc, pOnlyNumbers));
		}
		
		printMatrixList(bingomocho);
		
	}
	
	static String[][] boardParser(Scanner sc, Pattern p) {
	    String[][] board = new String[5][5];
	    System.out.println("df");
	    return board;
	}
	
	static void printMatrixList(ArrayList<String[][]> matrixList) {
	    for (String[][] matrix : matrixList) {
	        for (String[] row : matrix) {
	            for (String element : row) {
	                System.out.print(element + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	}

}
