package aoc2022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

// 70369 Resultado parte 1
// 203002 Resultado parte 2

public class Day1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(Day1.class.getResourceAsStream("/2022/day1Input.txt"));
		Vector<String> data = new Vector<>();
		while (scanner.hasNextLine()) {
			String temp = scanner.nextLine();
			data.addElement(temp);
		}
		scanner.close();
		
		int[] resultado = elfsSum(data);
		
		Arrays.sort(resultado);
		
		System.out.println("Los elfos con más calorías son:\n1. " + resultado[resultado.length - 1] + " [Part_One result]");
		System.out.println("2. " + resultado[resultado.length - 2]);
		System.out.println("3. " + resultado[resultado.length - 3]);

		System.out.println("\n[Part_Two] La suma de los tres elfos con más calorias es: " + sumaPrimeros(resultado));

	}

	static int[] elfsSum(Vector<String> v) {
		int suma = 0;
		int[] result = new int[v.size()];
		boolean fin = false;
		int c = 0;
		int x = 0;

		do {
			if (v.elementAt(c) != "" && c < v.size()) {
				suma += Integer.parseInt(v.elementAt(c++));
			}
			if (v.elementAt(c) == "" && c < v.size()) {
				result[x++] = suma;
				c++;
				suma = 0;
			} else if (c >= v.size() - 1) {
				fin = true;
			}
		} while (!fin);

		return result;
	}
	
	static int sumaPrimeros(int[] v) {
		int suma = 0;
		for (int i = v.length - 1; i >= v.length - 3; i--) {
			suma = suma + v[i];
		}
		return suma;
	}

}
