package aoc2020;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2020/test/day4Input.txt"));
		Pattern p = Pattern.compile("([a-z]{3}):");
		ArrayList<String> passports = new ArrayList<>();
		String line = "";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			
			if(line != "\n") {
				
			}
			
		}
	}

}
