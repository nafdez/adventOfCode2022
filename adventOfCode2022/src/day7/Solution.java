package day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		node in = new node(12, "f", false);
		FileInputStream f = new FileInputStream(
				"C:/Users/Nacho/git/adventOfCode2022/adventOfCode2022/src/day7/Input_test.txt");
		Scanner sc = new Scanner(f);		
		node root = new node("/", null);
		node route = root;
		boolean lsStatus = false;
		
		while (sc.hasNextLine()) {	
			String input = sc.nextLine();
			if(input.charAt(0) == '$') {
				lsStatus=false;
				String cmd = input.substring(2, 4);
				if(cmd.equals("cd")) {
					route = cdRun(route, root, input.substring(5, input.length()));
				} else if(cmd.equals("ls")) {
					lsStatus = true;
				}
			} else if(lsStatus) {
				if(input.substring(0, 3).equals("dir")) {
					route.addChild(input.substring(4, input.length()), route);
				} else {
					int size = Integer.parseInt(input.substring(0, input.indexOf(" ")));
					String name = input.substring(input.indexOf(" ")+1, input.length());
					route.addFile(name, size, route);
				}
			}		
		}
		sc.close();
		
//		node root = new node("/", null);
//		
//		root.addChild("a", root);
//		root.addChild("b", root);
//		root.addFile("Matrioska.txt", 233413, root);
//
//		lsRun(root);
//		mostrarVector("~ ", data);
	}
	
	static node cdRun(node route, node root, String to) {
		if(to.equals("/")) {
			return root;
		} else if(to.equals("..")) {
			route = route.parent;
			return route;
		} else {
			for(node current : route.childs) {
				if(current.name.equals(to)) {
					return current;
				}
			}
		}
		return root;
	}
	
	static void lsRun(node route) {
		for(int i=0; i<route.childs.size(); i++) {
			System.out.println(route.childs.elementAt(i).name + " (dir)");
		}
		
		for(int i=0; i<route.files.size(); i++) {
			System.out.println(route.files.elementAt(i).size + " " + route.files.elementAt(i).name);
		}		
	}

	static void mostrarVector(String msj, Vector<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(msj);
			System.out.println(a.elementAt(i));
		}
	}

}
