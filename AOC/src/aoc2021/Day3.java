package aoc2021;

import java.util.ArrayList;
import java.util.Scanner;

// Pasé de la parte dos, menudo coñazo

public class Day3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day3.class.getResourceAsStream("/2021/day3Input.txt"));

		int gammaRate = 0; // Most common bit (0 or 1) in each column of the binary numbers, forming a new
							// binary code
		int epsilonRate = 0; // EpsilonRate it's the same but using the least common. After that you should
								// use the conversion for decimal
		ArrayList<String> data = new ArrayList<>();

		while (sc.hasNextLine()) {
			parser(sc, data);
		}
		/** PART ONE **/
		int[][] codeData = toIntMatrix(data);
		gammaRate = toDecimal(mostCommon(codeData));
		epsilonRate = toDecimal(leastCommon(codeData));

		System.out.println("[Part_One] The power consumption of the submarine is " + (gammaRate * epsilonRate) + "W");
		/*************************************************************************************************************/
	}

	static int toDecimal(String code) {
		int decimal = 0;
		int count = 0;
		for (int i = code.length() - 1; i >= 0; i--) {
			int binNumber = Character.getNumericValue(code.charAt(i));
			decimal += (int) (binNumber * Math.pow(2, count++));
		}
		return decimal;
	}

	static String leastCommon(int[][] codeData) {
		String leastCommon = "";
		for (int i = 0; i < codeData[0].length; i++) {
			int countZero = 0;
			int countOne = 0;
			for (int[] element : codeData) {
				switch (element[i]) {
				case (0):
					countZero++;
					break;
				case (1):
					countOne++;
					break;
				}
			}
			if (countZero > countOne) {
				leastCommon += 1;
			} else {
				leastCommon += 0;
			}
		}
		return leastCommon;
	}

	static String mostCommon(int[][] codeData) {
		String mostCommon = "";
		for (int i = 0; i < codeData[0].length; i++) {
			int countZero = 0;
			int countOne = 0;
			for (int[] element : codeData) {
				switch (element[i]) {
				case (0):
					countZero++;
					break;
				case (1):
					countOne++;
					break;
				}
			}
			if (countZero > countOne) {
				mostCommon += 0;
			} else {
				mostCommon += 1;
			}
		}
		return mostCommon.toString();
	}

	static int[][] toIntMatrix(ArrayList<String> data) {
		int[][] matrix = new int[data.size()][data.get(0).length()];
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < data.get(i).length(); j++) {
				matrix[i][j] = Integer.valueOf(Character.toString(data.get(i).charAt(j)));
			}
		}
		return matrix;
	}

	static void parser(Scanner sc, ArrayList<String> data) {
		String temp = sc.nextLine();
		data.add(temp);
	}

}
