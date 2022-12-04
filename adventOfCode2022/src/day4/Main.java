package day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int c = 0;
		try {
			FileInputStream file = new FileInputStream(
					"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day4/Input.txt");
			Scanner scanner = new Scanner(file);
			Vector<String> data = new Vector<>();
			while (scanner.hasNext()) {
				String temp = scanner.nextLine().replaceAll(",", "-");
				data.addElement(temp);
				c++;
			}
			int[][] intData = toInt(data, c);

			int partOverlaps = 0;
			int fullOverlaps = 0;
			for (int i = 0; i < intData.length; i++) {
				String par1 = zoneToClean(intData, i, 2);
				String par2 = zoneToClean(intData, i, 1);
				
				if (fullyOverlaps(intData, i))
					fullOverlaps++;
				
				if (searchInIndex(par1, par2))
					partOverlaps++;
			}
			
			System.out.println("La cantidad de superposiciones TOTALES entre las parejas son: " + fullOverlaps);
			System.out.println("La cantidad de superposiciones entre las parejas son: " + (partOverlaps));

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int[][] toInt(Vector<String> v, int c) {
		int[][] aux = new int[c][4];
		for (int i = 0; i < c; i++) {
			String[] test = v.elementAt(i).split("-");
			for (int j = 0; j < 4; j++)
				aux[i][j] = Integer.valueOf(test[j]);
		}

		return aux;

	}

	static String zoneToClean(int[][] intData, int i, int value) {
		String zone = "";
		int c = 1; // contador
		int auxC = 0; // nuevo contador
		// aux posición 1 del primer par. // c la 2 pos.
		// se suma 2 para pasar al siguiente par

		if (value == 1) { // Con value sabemos si es el primero o el segundo del par;
			c = 3;
			auxC = 2;
		}
		for (int x = intData[i][auxC]; x < intData[i][c] + 1; x++) {
			zone = zone.concat(String.valueOf(x)+" ");
		}

		return zone;
	}

	static boolean overlaps(String par1, String par2, int[][] data, int i) {
		if (par1.contains(String.valueOf(data[i][2])) || par1.contains(String.valueOf(data[i][3])))
			return true;
		else if (par2.contains(String.valueOf(data[i][0])) || par2.contains(String.valueOf(data[i][1])))
			return true;
		return false;
	}
	
	static boolean fullyOverlaps(int[][] intData, int i) {
		if (intData[i][0]<=intData[i][2] && intData[i][1]>=intData[i][3])
			return true;
		else if(intData[i][0]>=intData[i][2] && intData[i][1]<=intData[i][3])
			return true;
		return false;
	}
	
	static boolean searchInIndex(String str01, String str02) {
		int l = str02.length();
		if (str01.length() > str02.length())
			l = str01.length();

		int c2 = 0;
		int c = 0;
		for (int j = 0; j < str02.length(); j++) {
			try {
				c2 = str01.charAt(str01.indexOf(str02.charAt(j)));
				if(c2!=-1)
					return true;
			} catch (StringIndexOutOfBoundsException e) {
				c--;
			}
		}
		return false;

	}

}
