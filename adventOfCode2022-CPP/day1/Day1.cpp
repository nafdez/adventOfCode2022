/*
 * Day1.cpp
 *
 *  Created on: 12 dic 2022
 *      Author: nafdez
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(){
	string fname = "Input.txt";
	ifstream file(fname.c_str());

	string line;
	int c;
	int in[10];
	int sum;
	int cal;

	// Obteniendo una línea del archivo y almacenarla en la variable "line"
	while(getline(file, line)) {
		
		if((line != "") && (line != " ") && (line != "\n")){
			int n = stoi(line);
			in[c] = n;
			cout << n << endl;
		} else
		{
			in[c] = 0;
		}
		c++;
	}

	for(int i = 0; i<sizeof(in); i++) {
		cout << in[i] << endl;
	}

	return 0;
}




