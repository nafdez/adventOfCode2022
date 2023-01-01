package aoc2020;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(Day4.class.getResourceAsStream("/2020/day5Input.txt"));
		
		int highestSeat = 0;
		int boardPassSeat = 0;
		
		ArrayList<Integer> passCodes = new ArrayList<>(); // Almacenando para la part two
		
		while(sc.hasNextLine()) {
			String pass = sc.nextLine();
			
			int resultFrontBack = calculateHalfs(pass, 'F', 'B', 0, 7, 127);

			int resultRightLeft = calculateHalfs(pass, 'L', 'R', 7, 3, 7);
			
			boardPassSeat = resultFrontBack * 8 + resultRightLeft;
			
			passCodes.add(boardPassSeat);
			
			if(boardPassSeat > highestSeat)
				highestSeat = boardPassSeat;
		}
		
		System.out.println("[Part_One]: " + highestSeat);
		
		/****Part Two****/
		
		passCodes.sort(null);
		int avalaibleSeat = 0;
		
		for(int i = 1; i < passCodes.size()-1; i++) {
			int previousSeat = passCodes.get(i-1);
			int nextSeat = passCodes.get(i+1);
			
			if((passCodes.get(i) - previousSeat) > 1) {
				avalaibleSeat= passCodes.get(i) - 1;
			} else if ((nextSeat - passCodes.get(i)) > 1) {
				avalaibleSeat = passCodes.get(i) + 1;
			}			
		}
		
		System.out.println("[Part_Two] The only avalaible seat is the number " + avalaibleSeat);
		
	}
	
	public static int calculateHalfs(String pass, final char lower, final char upper, int start, int cut, int max) { // cut = caracter de corte 0-10 format
		double value = 0;
		double secondHalf = max;
		double firstHalf = 0;
		
		cut = start + cut; // Para hacerlo más sencillo, por ejemplo de izq a dcha, empieza en 7 y acaba en 10
		
		for(int i = start; i < cut; i++) {
			value = secondHalf - firstHalf;
			if(pass.charAt(i) == lower)
				secondHalf = Math.floor(Math.abs((value/2)-secondHalf));
			else if (pass.charAt(i) == upper)
				firstHalf = Math.ceil((value / 2)+firstHalf); 
			
			if(i== cut-1  && pass.charAt(i) == lower) // cut-1 para el formato 0-9
				value = secondHalf; // Reusamos la variable para no crear otra
			else if(i == cut-1 && pass.charAt(i) == upper)
				value = firstHalf;
		}
		return (int) value;
	}

}
