package day7;

import java.util.Arrays;

public class apuntes {

	public class nodeTest {
		int size; // Se declaran las variables
		String name;
		boolean dir;
		
		public nodeTest(int size, String name, boolean dir) { // Esto es el constructor del objeto
			this.size=size; // Con "this" se "bloquea" la variable, solo pudiendo cambiar los valores mediante una función
			this.name=name;
			this.dir=dir;
		}
		
		public int getSize() {
			return size; // Para obtener el valor de una variable
		}
		
		public int updateSize(int n) {
				size = n;	// Pa cambiar la variable se crea una función como esta
			return size;
		}
		
	}
	
	public static void main(String[] args) {
		String str = "28736 pfqcbp.pfg";
		String name = str.replaceAll("\\p{Digit}", "").replaceAll(" ", "");
		String size = str.replaceAll("([a-zA-Z]+)(\\p{Punct}?)([a-zA-Z]+)", "").replaceAll(" ", "");
		System.out.println(name +"\n"+ size);
		
		int[] test = {1,4,2,64,46,4}; 
		for(int i : test) { // for(type name in array)
			System.out.println(i);
		}
		
		
	}

}
