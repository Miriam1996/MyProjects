//Miriam Schnoll
/*
This project generates random number anc counts the number of times a particular first digit occurs
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
//function finds the first digit of numbers
int firstdigit (int x){
while (x>10)	{
	x/=10;
}
return x;
}
int main(){
	//create array to store random numbers
	int myarray[14000];
	//intialize array of 10 to be the digits and intialize count of digits to zero
	int array[10]={0};
	//use srand to generate random numbers
	srand (time(NULL));
	//put random numbers in array
		for (int i=0; i<14000;i++){
		int j = rand()+1%14000;
		myarray[i]=j;
		
	}
	//find out how often th first digit of the random numbers show up
	//store count in each index of the array
	for (int t=0; t<14000; t++){
		array [firstdigit(myarray[t])] ++;
	
			
	}
	//print out results
	for (int i=1;i<10;i++){
		cout << "The digit " <<i <<" " << "occurs " << array[i] << " times." <<endl;
	}
}
