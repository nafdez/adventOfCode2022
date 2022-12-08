package day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
	
	public static class node {
		int size;
		String name;
		boolean dir;
		
		public node(int size, String name, boolean dir) {
			this.size=size;
			this.name=name;
			this.dir=dir;
		}
		
		public int getSize() {
			return size;
		}
		
		public int updateSize(int n) {
				size = n;
			return size;
		}
		
		public String getName() {
			return name; 
		}
		
		public String updateName(String n) {
				name = n;
			return name;
		}
		
	}
	
	public static class cmd {
		String type;
		
		public cmd(String type) {
			this.type = type;
		}
		
		public String getType() {
			return type;
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {
//		node in = new node(12, "f", false);
		FileInputStream f = new FileInputStream("/home/nafdez/git/adventOfCode2022/adventOfCode2022/src/day7/Input_test.txt");
		Scanner sc = new Scanner(f);
		Vector<String> data = new Vector<>();
		while(sc.hasNextLine()) {
			data = parser(sc, data, "");
		}
		
		cmd commands[] = new cmd[5];
		
		cmd cd = new cmd("cd");
		
		for(int i=0; i<data.size(); i++) {
			if(data.elementAt(i).charAt(0) == '$') {
				
			}
					
		}
		
		mostrarVector("~ ", data);
	}
	
	static Vector<String> parser(Scanner sc, Vector<String> v, String regex) {
		String temp = "";

		try {
			sc.skip(regex);
			temp = sc.nextLine();
			if(temp.charAt(0)=='$')
				v.addElement(temp);
			else
				d.addElement(temp);
			v.addElement(temp);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return v;
	}
	
	static void mostrarVector(String msj, Vector<String> a) {
		for(int i=0; i<a.size(); i++) {
			System.out.print(msj);
			System.out.println(a.elementAt(i));
		}
	}
	
	

}
