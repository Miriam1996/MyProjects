//Miriam Schnoll Project 1
#include<iostream>
#include <cstdlib>
#include<cassert>
#include<algorithm>
//#pragma once
using namespace std;
template <class t> // forward declaration
class SA;
template <class t> //forward declaration
ostream& operator<<(ostream& os, SA<t> s);
template <class t>
class matrix;
template <class t>
ostream& operator<< (ostream& os, matrix<t> s);
template <class t>
class SA {
	private:
 	int low, high;
 	t* p;
	public:

	 // default constructor
 	// allows for writing things like SA a;

 	SA(){low=0; high=-1;p=NULL;}


 	// 2 parameter constructor lets us write
 	// SA x(10,20);

 	SA(int l, int h){
 	if((h-l+1)<=0)
 	{	cout<< "constructor error in bounds definition"<<endl;
 	exit(1);}
 	low=l;
 	high=h;
 	p=new t[h-l+1];
 	}


 	// single parameter constructor lets us
	 // create a SA almost like a "standard" one by writing
 	// SA x(10); and getting an array x indexed from 0 to 9

	 SA(int i){low=0; high=i-1;
 		p=new t[i];
	 }
 	// copy constructor for pass by value and
 	// initialization

 	SA(const SA & s){
 	int size=s.high-s.low+1;
 	p=new t[size];
 	for(int i=0; i<size; i++)
 	p[i]=s.p[i];
 	low=s.low;
 	high=s.high;
 	}	
 	// destructor

 	~SA(){
 	delete [] p;
 	}
 	//overloaded [] lets us write
 	//SA x(10,20); x[15]= 100;

 	t& operator[](int i){
 	if(i<low || i>high)
 	{cout<< "index "<<i<<" out of range"<<endl;
 	exit(1);}
 	return p[i-low];
 	}
 

	 // overloaded assignment lets us assign
 	// one SA to another

 	SA & operator=(const SA & s){
 	if(this==&s)return *this;
 	delete [] p;
 	int size=s.high-s.low+1;
 	p=new t[size];
 	for(int i=0; i<size; i++)
 	p[i]=s.p[i];
 	low=s.low;
 	high=s.high;
 	return *this;
 	}
 	//gets the high
 int getHigh(){
 	return high;
	}
	//gets the low
	int getLow(){
		return low;
	}
	//create a pointer to beggining to iterate
	t* begin(){
		return p;
	}
	//create a pointer to end to iterate
	t* end(){
		return p+high-low+1;
	}
 // overloads << so we can directly print SAs
	friend ostream& operator<< <t> (ostream& os, SA<t> s);

};
	template <class t>
	ostream& operator<<(ostream& os, SA<t> s){
	int size=s.high-s.low+1;
	for(int i=0; i<size; i++)
 	os<<s.p[i]<< " ";
	return os;
	};
	
int main(){
	
SA<int> p(5);
p[0]=45;
p[1]=23;
p[2]=14;
p[3]=78;
p[4]=56;
	cout<<"before sort" <<endl;
	cout<<p<<endl;
	if(find(p.begin(),p.end(),1)!=p.end())
		cout<< "1 is found"<<endl;
	else 
		cout<<"1 is not found"<<endl;
		
	cout<<"after sort" <<endl;
	sort(p.begin(),p.end());
	cout<<p<<endl;
		if(find(p.begin(),p.end(),45)!=p.end())
		cout<< "45 is found"<<endl;
	else 
		cout<<"45 is not found"<<endl;
	
return 0;
} 
