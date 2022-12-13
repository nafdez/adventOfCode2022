package day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		FileInputStream f = null;
		try {
			f = new FileInputStream("C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day8/Input.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(f);
		Vector<String> data = new Vector<>();

		while (sc.hasNextLine()) {
			data = parser(sc, data);
		}

		int[][] forest = new int[data.size()][data.elementAt(0).length()];

		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest[0].length; j++) {
				forest[i][j] = Integer.valueOf(Character.toString(data.elementAt(i).charAt(j)));
			}
		}

		int visibles = 0;

		int realVL = forest.length - 1;
		int realHL = forest[0].length - 1;
		int countH = 0;
		int countV = 0;
		for (int i = 0; i <= realVL; i++) {
			for (int j = 0; j <= realHL; j++) {
				int tree = forest[i][j];
				if (i == 0 || j == 0 || i == realVL || j == realHL || visibleLeft(forest, tree, i, j)
						|| visibleRight(forest, tree, i, j, realHL) || visibleUp(forest, tree, i, j)
						|| visibleDown(forest, tree, i, j, realVL))
					visibles++;
				countH++;
			}
			countV++;
		}

		System.out.println("Curiosidades:\n~Tamaño del bosque: " + (forest.length * forest[0].length)
				+ "\n~Fotografía aérea del bosque:");
//		for(String i : data)
//			System.out.println(i);
		System.out.println("\nEl número de árboles visibles es de: " + visibles + "\n\nforest.length: " + realVL
				+ "\nforest[0].length: " + realHL);
		System.out.println(countV + " " + countH);
	}

	static boolean visibleLeft(int[][] forest, int tree, int i, int j) {
		if (j == 0)
			return true;
		else {
			for (int l = j - 1; l >= 0; l--) {
				int pos = forest[i][l];
				if (pos >= tree)
					return false;
			}
		}
		return true;
	}

	static boolean visibleRight(int[][] forest, int tree, int i, int j, int hLen) {
		if (j == 0)
			return true;
		else {
			for (int r = j + 1; r <= hLen; r++) {
				int pos = forest[i][r];
				if (pos >= tree)
					return false;
			}
		}
		return true;
	}

	static boolean visibleUp(int[][] forest, int tree, int i, int j) {
		if (i == 0)
			return true;
		else {
			for (int u = i - 1; u >= 0; u--) {
				int pos = forest[u][j];
				if (pos >= tree)
					return false;
			}
		}
		return true;
	}

	static boolean visibleDown(int[][] forest, int tree, int i, int j, int vLen) {
		if (i == 0)
			return true;
		else {
			for (int d = j + 1; d <= vLen; d++) {
				int pos = forest[d][j];
				if (pos >= tree)
					return false;
			}
		}
		return true;
	}

	static Vector<String> parser(Scanner sc, Vector<String> v) {
		String temp = "";
		try {
			temp = sc.nextLine();
			v.add(temp);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return v;
	}

}
