package day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

// 70369 Resultado

public class part1_optimizado {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(
					"/home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day1/part1_Input.txt");
			Scanner scanner = new Scanner(file);
			Vector<String> data = new Vector<String>();
			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				data.addElement(temp);
			}
			scanner.close();
			long t0 = System.nanoTime();
			int [] resultado = elfsSum(data); // Original: 3'2 ms
			long t1 = System.nanoTime();
			
			Arrays.sort(resultado); // Usando Arrays.sort instead of mi propio método de ordenación, hago que ordenar el array sea unas 10 veces más rápido
			
			System.out.println("El elfo con más calorías es: " + resultado[resultado.length - 1]);
			System.out.println("Tiempo de ejecución para sumar todos los elementos a la vez que se de un vector pasamos a un array: " + (t1-t0)/1e6 + " ms.");

		} catch (IOException e) {
			e.printStackTrace();
		}

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
			} else if (c >= v.size()-1) {
				fin = true;
			}
		} while (!fin);

		return result;

	}

}
