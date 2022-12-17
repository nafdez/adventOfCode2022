package aoc2021;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(Day1.class.getResourceAsStream("/day1Input.txt"))) {

			ArrayList<Integer> measures = new ArrayList<>();

			while (sc.hasNextInt()) {
				measures.add(sc.nextInt());
			}

			System.out.println("[Part_One] Se han detectado " + partOne(measures) + " incrementos en la profundidad.");
			System.out.println("[Part_Two] En grupos de tres, se han detectado " + partTwo(measures)
					+ " incrementos en la profundidad.");
		}
	}

	static int partOne(ArrayList<Integer> msr) {
		int contador = 0;
		for (int i = 0; i < msr.size() - 1; i++) {
			if (msr.get(i + 1) > msr.get(i))
				contador++;
		}
		return contador;
	}

	static int partTwo(ArrayList<Integer> msr) {
		int contador = 0;
		for (int i = 0; i < msr.size() - 3; i++) {
			int sumFirstWindow = msr.get(i) + msr.get(i + 1) + msr.get(i + 2);
			int sumSecondWindow = msr.get(i + 1) + msr.get(i + 2) + msr.get(i + 3);
			if (sumSecondWindow > sumFirstWindow) {
				contador++;
			}
		}
		return contador;
	}

}
