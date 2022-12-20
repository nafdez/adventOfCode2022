package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Specifically, they need you to find the two entries that sum to 2020 
 * and then multiply those two numbers together.
 */

public class Day1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(Day1.class.getResourceAsStream("/2020/day1Input.txt")));
		int entry = 0;
		int c = 0;
		int[] vector = new int[300];
		
		boolean nCorrect = true;
		
		do {
			try {
				entry = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				nCorrect = false;
			}
			if(nCorrect) {
				toArray(vector, entry, c);
				c++;
			}
			
		}while(nCorrect);
		
		System.out.println(searchEntries(vector));
	}
	
	static void toArray(int[] v, int entry, int c) {
		v[c] = entry;
	}
	
	static int searchEntries(int[] v) {
		int aux = 0;
		
		for(int i=0; i<v.length; i++) {
			for(int j=0; j<v.length; j++) {
				for(int x=0; x<v.length; x++) {
					aux = v[i] + v[j] + v[x];
					if(aux == 2020)
						return v[i]*v[j]*v[x];
				}
			}
		}
		
		return 0;
	}
}

