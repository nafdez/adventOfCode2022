package aoc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(Day5.class.getResourceAsStream("/2021/test/day5Input.txt")));
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<>();
		
		String line = "";
		while((line = in.readLine()) != null) {
			int separatorComa = line.indexOf(","); // Primera coma en el input
			int separatorLastComa = line.lastIndexOf(","); // Coma de las segundas coordenadas
			int x1 = Integer.parseInt(line.substring(0, separatorComa));
			int y1 = Character.getNumericValue(line.charAt(separatorComa+1));
			
			int x2 = Character.getNumericValue(line.charAt(separatorLastComa-1));
			int y2 = Character.getNumericValue(line.charAt(separatorLastComa+1));
			
			System.out.println(x1 + " " + y1 + " -- " + x2 + " " + y2);
			
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					
				}
			}
			
		}

	}

}
