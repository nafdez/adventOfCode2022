package aoc2022;

import java.util.Scanner;
import java.util.Vector;

//Pendiente de simplificar

public class Day3 {
	public static void main(String[] args) {
		// Variables
		String[] hvStr = new String[2];
		String[] p2HvStr = new String[3];
		int cAux = 0;
		int result = 0;
		int result2 = 0;
		int prioraz = 0;
		int priorAZ = 0;
		String c1a = "";
		String badge = "";
		String az = "";
		String AZ = "";

		// Proceso
		Scanner scanner = new Scanner(Day3.class.getResourceAsStream("/2022/day3Input.txt"));
		Vector<String> data = new Vector<>();
		while (scanner.hasNextLine()) {
			String temp = scanner.nextLine();
			data.addElement(temp);
		}

		// Asignando a az todo el abecedario, y lo mismo con AZ
		for (char c = 'a'; c <= 'z'; ++c)
			az += c;
		for (char c = 'A'; c <= 'Z'; ++c)
			AZ += c;

		// Separando el input en dos
		/*** PART ONE ***/
		for (int i = 0; i < data.size(); i++) {
			hvStr = stringHalving(data, i);

			c1a = String.valueOf(searchInIndexPartOne(hvStr[0], hvStr[1]));

			// Establecemos prioridades del 1 al 26 para a-z y 27-52 para A-Z
			prioraz = az.indexOf(c1a) + 1;
			priorAZ = AZ.indexOf(c1a) + 27;
			if (priorAZ == 26) // Como le sumamos 27, para hacerlo más fácil si el resultado da 26, será 0
				priorAZ = 0;
			result += prioraz + priorAZ;
		}

		/*** PART TWO ***/
		// Separando el input en dos
		for (int i = 0; i < data.size(); i = i + 3) {
			for (int j = 0; j < 3; j++)
				p2HvStr[j] = data.elementAt(cAux++);

			String idkWhatImRefactoring = String.valueOf(searchInIndexPartTwo(p2HvStr[0], p2HvStr[1]));
			badge = String.valueOf(searchInIndexPartTwo(idkWhatImRefactoring, p2HvStr[2])[0]); // index 0, porque puede
																								// que la común se
																								// repita

			// Establecemos prioridades del 1 al 26 para a-z y 27-52 para A-Z
			prioraz = az.indexOf(badge) + 1;
			priorAZ = AZ.indexOf(badge) + 27;
			if (priorAZ == 26) // Como le sumamos 27, para hacerlo más fácil si el resultado da 26, será 0
				priorAZ = 0;
			result2 += prioraz + priorAZ;
		}

		scanner.close();

		System.out.println("[Part_One] La suma de todos los items es: " + result);
		System.out.println("[Part_Two] La suma de todos los items es: " + result2);
	}

	static String[] stringHalving(Vector<String> data, int i) {
		String[] strAux = new String[2];
		strAux[0] = data.elementAt(i).substring(0, data.elementAt(i).length() / 2);
		strAux[1] = data.elementAt(i).substring(data.elementAt(i).length() / 2);
		return strAux;
	}

	static String[][] stringGroups(Vector<String> data, String[][] strAux, int i, int j) {
		strAux[j][0] = data.elementAt(i).substring(0, data.elementAt(i).length() / 2);
		strAux[j][1] = data.elementAt(i).substring(data.elementAt(i).length() / 2);
		return strAux;
	}

	static char searchInIndexPartOne(String s1a, String s1b) {
		char c2 = ' ';
		for (int j = 0; j < s1b.length(); j++) {
			try {
				c2 = s1b.charAt(s1b.indexOf(s1a.charAt(j)));
			} catch (StringIndexOutOfBoundsException e) {
			}
		}
		return c2;
	}

	static char[] searchInIndexPartTwo(String str01, String str02) {
		// Evaluo cual string es más largo para que c2 no se quede sin espacio nunca
		// Dado el caso que si los 2 string son iguales, c2 se llenaría muy rápido
		int l = str02.length();
		if (str01.length() > str02.length())
			l = str01.length();
		// Función principal
		char c2[] = new char[l];
		int c = 0;
		for (int j = 0; j < str02.length(); j++) {
			try {
				c2[c++] = str01.charAt(str01.indexOf(str02.charAt(j)));
			} catch (StringIndexOutOfBoundsException e) {
				c--;
			}
		}
		return c2;

		// Buscando la letra repetida
		// Try/catch porque indexOf si no encuentra nada da -1,
		// y para que no se cague encima y siga buscando
		// en bucle
	}
}
