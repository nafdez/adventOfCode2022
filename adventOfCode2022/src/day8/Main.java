package day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		FileInputStream f = null;
		try {
			f = new FileInputStream("/home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day8/Input_test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(f);
		Vector<String> data = new Vector<>();
		
		while(sc.hasNextLine()) {
			data = parser(sc, data);
		}
		for(String i : data)
			System.out.println(i);
		
		int[][] forest = new int[data.size()][data.elementAt(0).length()];
		
		for(int i = 0; i<forest.length; i++) {
			for(int j = 0; j<forest[0].length; j++) {
				forest[i][j] = Integer.valueOf(Character.toString(data.elementAt(i).charAt(j)));
			}
		}
		
		for(int[] i : forest) {
			System.out.println(Arrays.toString(i));
		}
		
		boolean visible = true;
		int c=0;
		
		for(int i = 0; i<forest.length; i++) {
			for(int j = 0; j<forest[i].length; j++) {
				int tree = forest[i][j];
				for(int fila = 0; fila<forest[i].length; fila++) {
					if(tree <= forest[i][fila]) {
						visible = false;
					}
				}
				for(int columna = 0; columna<forest.length; columna++) {
					if(tree <= forest[columna][j]) {
						visible = false;
					}
				}
				if(!visible)
					c++;
			}
		}
		
		System.out.println(c);
		
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
