package day7;

import java.util.Vector;

public class node {
	int bottomUpSize;
	Vector<file> files;
	String name;
	node parent;
	Vector<node> childs;
	
	public node(String name, node parent) {
		this.name = name;
		this.parent = parent;
		files = new Vector<file>();
		childs = new Vector<node>();
	}
	
	public void addChild(String name, node prnt) {
		node child = new node(name, prnt);
		prnt.childs.add(child); // prnt es el nombre del nodo, childs el vector del nodo prnt y .add para añadir información al vector.
	}
	
	public void addFile(String name, int size, node dir) {
		file f = new file(size, name);
		dir.files.add(f); // dir es el nombre del directorio donde se guarda, files el vector donde consta que el nodo tiene esos archivos
	}
	
}
