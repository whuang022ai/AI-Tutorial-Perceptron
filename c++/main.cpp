/***************************************************************************
*
*  main.cpp
*  
*
*
* This is a hard coding version of Sigmoid Perceptron.
* It is just for "Hello World" for the A.I beginners.
*
*
***************************************************************************
* Copyright 2018 whuang022.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* 
 **************************************************************************/
 
#include <iostream>
#include <cmath>
#include <ctime>
#include <cstdlib>

double eta=0.7;//learning rate
double w1=0;
double w2=0;
double b1=0;

// The Neural
// neural(input1,input2,desire output)

double neural(double x1,double x2,double d){
	//forward path
	double n=w1*x1+w2*x2+b1;	
	double o =1/(1+exp(-n));
	//backward path
	w1+=eta*(d-o)*o*(1-o)*x1;
	w2+=eta*(d-o)*o*(1-o)*x2;
	b1+=eta*(d-o)*o*(1-o)* 1;	
	return (d-o);
}

// learn AND
// this will converge
void neuralAND(){
	int	 x=rand()%2;
	int	 y=rand()%2;
	int  z=x&y;
	std::cout << neural(x,y,z)<<"\n";
}

// learn OR
// this will converge
void neuralOR(){
	int	 x=rand()%2;
	int	 y=rand()%2;
	int  z=x|y;
	std::cout << neural(x,y,z)<<"\n";
}

// learn XOR
// this will not converge
void neuralXOR(){
	int	 x=rand()%2;
	int	 y=rand()%2;
	int  z=x^y;
	std::cout << neural(x,y,z)<<"\n";
}

// Init the weight
// random 0~1 

void init(){
	srand(time(0));
	w1=double(std::rand()) / (double(RAND_MAX) + 1.0);
	w2=double(std::rand()) / (double(RAND_MAX) + 1.0);
	b1=double(std::rand()) / (double(RAND_MAX) + 1.0);
}

int main(int argc, char** argv) {	
	for(double i=0;i<1000;i++){
		neuralOR();
	}
}
