package day7;

public class apuntes {

	public class node {
		int size; // Se declaran las variables
		String name;
		boolean dir;
		
		public node(int size, String name, boolean dir) { // Esto es el constructor del objeto
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
		
	}

}
