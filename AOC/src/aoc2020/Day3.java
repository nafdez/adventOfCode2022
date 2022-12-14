package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day3 {

	public static void main(String[] args) throws IOException {
		BufferedReader initialMap = new BufferedReader(new InputStreamReader(Day3.class.getResourceAsStream("/2020/day3Input.txt")));
		
		ArrayList<String> map = new ArrayList<>();
		
		String line = "";
		while((line = initialMap.readLine()) != null) {
			String temp = "";
			for (int i = 0; i < line.length(); i++) {
				temp += String.valueOf(line.charAt(i));
			}
			map.add(temp);
		}
	
		int result_PartOne = busCaminos(map, 3, 1);
		// PART TWO r1_P2 (r = result; P2 = Part Two)
		int r1_P2 = busCaminos(map, 1, 1);
		int r2_P2 = busCaminos(map, 5, 1);
		int r3_P2 = busCaminos(map, 7, 1);
		int r4_P2 = busCaminos(map, 1, 2);
		

		for(String i : map)
			System.out.println(i);
		
		System.out.println("[Part_One] En el camino se han encontrado con " + result_PartOne + " árboles.");
		System.out.println("[Part_Two] En el camino se han encontrado con " + (result_PartOne*r1_P2*r2_P2*r3_P2*r4_P2) + " árboles.");
	}
	
	static int busCaminos(ArrayList<String> m, int pasoX, int pasoY) {
		String[] map = new String[m.size()]; // Covierto a String[] porque no se como borrar el ArrayList después de cada resultado jajjaja
		for(int i = 0; i < map.length; i++) {
				map[i] = m.get(i);
		}
		
		boolean bottomReached = false;
		int x = 0;
		int y = 0;
		
		while(!bottomReached) {
			x += pasoX;
			y += pasoY;
			if(x >= map[y].length())
				x -= map[y].length();
			
			char xYAxis = map[y].charAt(x);
			String yAxis = map[y];
			if(xYAxis == '.') {
				 yAxis = yAxis.substring(0, x) + "O" + yAxis.substring(x+1);
			} else if(xYAxis == '#'){
				yAxis = yAxis.substring(0, x) + "X" + yAxis.substring(x+1);
			}
			
			map[y] = yAxis;
			if(y == map.length-1)
				bottomReached = true;
		}
		
		int result = cuantosArboles(map);
		return result;
	}
	
	static int cuantosArboles(String[] m) {
		int count = 0;
		for(String i : m) {
			for(int j = 0; j < i.length(); j++) {
				if(i.charAt(j) == 'X')
					count++;
			}
		}
		return count;
	}

}
