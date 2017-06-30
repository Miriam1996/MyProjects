//Miriam Schnoll project 6
#include <iostream>
#include<map>
#include <iterator>
#include <sstream>
#include <fstream>
using namespace std;
	
	map<int,int> add(map<int,int> m, map<int,int> k){
		map<int,int> sum;
		//puts first one into sum
		for (map<int,int>::iterator iter = m.begin();iter != m.end(); ++iter)
			sum.insert ( std::pair<int,int>(iter->first,iter->second));	
			//adds 2nd one
			for (map<int,int>::iterator iter = k.begin();iter != k.end(); ++iter)
			//if key is the same add value to current value
				if(m.find(iter->first) != m.end())
					sum[iter->first]+=iter->second;
				else
					//otherwise insert it
					sum.insert ( std::pair<int,int>(iter->first,iter->second));	
		return sum;
}
		map<int,int> subtract(map<int,int> m, map<int,int> k){
		map<int,int> sum;
		//puts first one in sum
		for (map<int,int>::iterator iter = m.begin();iter != m.end(); ++iter)
			sum.insert ( std::pair<int,int>(iter->first,iter->second));	
			for (map<int,int>::iterator iter = k.begin();iter != k.end(); ++iter)
				if(m.find(iter->first) != m.end())
					sum[iter->first]-=iter->second;
				else{
					int t=-1*iter->second;
					sum.insert ( std::pair<int,int>(iter->first,t));
				}
		return sum;
}
	map<int,int> multiply(map<int,int> m, map<int,int> k){
		map<int,int> product;
		//runs through both maps
		for (map<int,int>::iterator iter1 = m.begin();iter1 != m.end(); ++iter1){
			for (map<int,int>::iterator iter2= k.begin();iter2 != k.end(); ++iter2){
				int j=iter1->second*iter2->second;
				int l=iter1->first+iter2->first;
				//if key in map add values
				if(product.find(l) != product.end())
					product[l]+=j;
				else
					//insert
					product.insert ( std::pair<int,int>(l,j));
				}
		
		}
		return product;
	}
		void print(map<int,int> m,ofstream &InputFile){
			//runs through the map in reverse
			for (map<int,int>::reverse_iterator iter = m.rbegin();iter != m.rend(); ++iter){
				map<int,int>::reverse_iterator f=iter;
				f++;
				//for -x^
				if(iter->second ==-1 && iter->first!=0)
					InputFile<<"-";
				//for x^
				else if (iter->second==1&& iter->first!=0)
					InputFile<<"";
				//constant is 0
				else if (iter->second==0)
					InputFile<<"";
				else
				InputFile<<iter->second;
			if (iter->second!=0 && iter->first !=1&& iter->first!=0) // if power isn't 0 or 1 must print power form
				InputFile<< "x^" <<iter->first;
			else if (iter->first== 1) // just print x
				InputFile<<"x";
			//checks if next number is positive to put a plus
			if(f->second>0)
				InputFile<< "+";
			//if the exponent is negative don't print a plus
			else if(f->second<0)
			InputFile<<"";
		}
		InputFile<<endl;	
	}
int main(){

	map<int,int> m;
	map<int,int> p;
	//reading from the file
	const char* filename = "C:/Users/Miriam Schnoll/workspace/polynomials.txt";
	ifstream infile(filename);
	//output file
	ofstream fout("project.txt");
	string s;
	int i;
	int j;
	//reads two lines and keeps track of it
	int lineat=1;
	//goes through each line
	while(infile.good()){
		getline(infile,s);
		
		stringstream t(s);
		t>>i;
		j=i;
		
		while(t>>i){
			//goes through every 2 lines in file 
			//adds and multiplies them
			if (lineat%2==1){
				if(m.find(i) != m.end())
					m[i]+=j;
				else	
				m.insert ( std::pair<int,int>(i,j));	
				
			}
			else if (lineat%2==0){
				if(p.find(i) != m.end())
					p[i]+=j;
				else
				p.insert ( std::pair<int,int>(i,j));
				
			
			}
		
		t>>i;
		j=i;
		}
		//prints after 2 lines have been read
		if(lineat%2==0){
			//outputs polynomial to text file
			fout<<"Polynomial1 regular form:" <<"     ";
			print(m,fout);
			fout<<endl;
			fout<<"Polynomial1 canonical form:"<<"    ";
			print(m,fout);
			fout<<endl;
			fout<<"Polynomial2 regular form:" <<"     ";
			print(p,fout);
			fout<<endl;
			fout<<"Polynomial2 canonical form:"<<"    ";
			print(p,fout);
			fout<<endl;
			fout<<"polynomial1 + polynomial2 = "<<"   ";
			map<int,int> y = add(m,p);
			map<int,int> z = subtract(m,p);
			print(y,fout);
			fout<<"polynomial1 - polynomial2 = "<<"   ";
			print(z,fout);
			fout<<endl;
			fout<<"polynomial1 * polynomial2 = "<<"   ";
			map<int,int> q= multiply(m,p);
			print(q,fout);
			fout<<endl;
			fout<<"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" <<endl;
			//resets polynomials for reuse in additional lines in file
			
			m.clear();
			p.clear();
		}
		lineat++;
			
			
	}
	fout.close();
	return 0;
				
}
