package aoc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

	public static void main(String[] args) {
		Pattern pOnlyNumbers = Pattern.compile("^\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)$");
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2021/test/day4Input.txt"));
		ArrayList<int[][]> bingomocho = new ArrayList<>();
		while(sc.hasNextLine()) {
			bingomocho.add(boardParser(sc, pOnlyNumbers));
		}
		
	}
	
	static int[][] boardParser(Scanner sc, Pattern p) {
		int[][] board = new int[5][5];
		String temp = "";
		int counter = 0;
		
		while(sc.hasNext()) {
			temp = sc.nextLine();
			Matcher m = p.matcher(temp);
			int counterGroup = 1;
			if(m.find()) {
				for(int i = 0; i<board[counter].length; i++) {
					board[counter][i] = Integer.valueOf(m.group(counterGroup++));
				}
			}
			if(counter<5)
				counter++;
			else
				counter=0;
		}
		for(int[] i : board)
			System.out.println(Arrays.toString(i));
		
		return board;
	}

}
