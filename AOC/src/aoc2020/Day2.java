package aoc2020;

import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day2.class.getResourceAsStream("/2020/day2Input.txt"));
		
		int result = 0;
		int resultPartTwo = 0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			int separator = line.indexOf("-");
			int min = Integer.parseInt(line.substring(0, separator));
			int separator2 = line.indexOf(" ");
			int max = Integer.parseInt(line.substring(separator+1, separator2));
			char c = line.charAt(separator2+1);
			String password = line.substring(separator2+4);
//			System.out.println(min + "-" + max + " " + c + ": " + password);
			//*****************************************************************
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				char cPW = password.charAt(i);
				
				if(cPW == c) {
					count++;
				}
			}
			if(count >= min && count <= max) {
				result++;
			}

			if((password.charAt(min-1) == c || password.charAt(max-1) == c) && !(password.charAt(min-1) == c && password.charAt(max-1) == c)) {
				resultPartTwo++;
			}
			
		}
		System.out.println(result);
		System.out.println(resultPartTwo);
	}

}
