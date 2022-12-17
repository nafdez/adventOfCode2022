package aoc2021;

import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day2.class.getResourceAsStream("/day2Input.txt"));

		int horizontalPos = 0; // Part One
		int depth = 0;
		int PThorizontalPos = 0; // Part Two
		int PTdepth = 0;
		int aim = 0;
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] cmd = line.split(" "); // Separa el input en dos, el comando (cmd[0]) y el valor de este (cmd[1]

			switch (cmd[0]) {
			case ("forward"):
				horizontalPos += Integer.valueOf(cmd[1]);
				PThorizontalPos += Integer.valueOf(cmd[1]);
				PTdepth += aim * Integer.valueOf(cmd[1]);
				break;
			case ("down"):
				depth += Integer.valueOf(cmd[1]);
				aim += Integer.valueOf(cmd[1]);
				break;
			case ("up"):
				depth -= Integer.valueOf(cmd[1]);
				aim -= Integer.valueOf(cmd[1]);
				break;
			}
		}

		System.out.println("[Part_One] Valor final: " + (horizontalPos * depth));
		System.out.println("[Part_Two] Valor final: " + (PThorizontalPos * PTdepth));

	}
}
