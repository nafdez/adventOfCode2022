package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day3 {

	public static void main(String[] args) throws IOException {
		BufferedReader initialMap = new BufferedReader(new InputStreamReader(Day3.class.getResourceAsStream("/2020/test/day3Input.txt")));
		
		ArrayList<String> map = new ArrayList<>();
		
		String line = "";
		while((line = initialMap.readLine()) != null) {
			String temp = "";
			for (int i = 0; i < line.length(); i++) {
				temp += String.valueOf(line.charAt(i));
			}
			map.add(temp);
		}
	
		int count = 0;
		boolean updateMap = true;
		
		String elfs = "X";
		int treeEncountered = 0;

		while(updateMap) {
			for(int i = 0; i < map.size(); i++) {
				map.set(i, map.get(i).concat(map.get(i)));
			}
			
			while(elfs != mapLimitLeft() || elfs != mapLimitRight()) {
				// Realizar movimiento
			}
			
			
			for(String i : map) {
				System.out.println(i);
			}
			count++;
			if(count >= 3)
				updateMap = false;
		}
		
	}

}
