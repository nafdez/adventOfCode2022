/*
 * Day1.cpp
 *
 *  Created on: 12 dic 2022
 *      Author: nafdez
 */

#include <iostream>
#include <fstream>
using namespace std;

int main(){
	string fname = "Input.txt";
	ifstream file(fname.c_str());

	string line;
	// Obteniendo una línea del archivo y almacenarla en la variable "line"
	while(getline(file, line)){
		cout << "line: " << line << endl;
	}

	return 0;
}




