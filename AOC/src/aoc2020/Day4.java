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
		ArrayList<String> values = new ArrayList<>();
		while(sc.hasNextLine()) {			
			values.add(sc.next("[a-z]{3}:"));
		}
		
		for(String i : values)
			System.out.println(i);
	}

}
