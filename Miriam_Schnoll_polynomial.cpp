//Miriam Schnoll
//Project 2
#include<iostream>
#include <sstream>
#include <fstream>
using namespace std;
class node {
	private:
	//polynomial constant and exponent
	int _constant;
	int _exponent;
	node* _next;

	public:
		node(){_next=0;
		}
		node(int c, int e) {
			_constant = c;
			_exponent = e;
			_next = 0;
		}
		node* &next(){
			return _next;
		}
		int constant(){
			return _constant;
		}
		int exponent(){
			return _exponent;
		}
		void setConstant(int c){
			_constant=c;
		}
		void setExponent(int e){
			_exponent=e;
		}
		~node(){
			delete _next;
		}
		friend ostream& operator  <<  (ostream& os, node &m);

	};
	 ostream& operator<< (ostream& os, node &m){

	if(m.constant() ==-1 && m.exponent()!=0)
		os<<"-";
	else if (m.constant()==1&& m.exponent()!=0)
	os<<"";
	else if (m.constant()==0)
	os<<"";
	else
		os<<m.constant();
	if (m.exponent()!=0 && m.exponent() !=1) // if power isn't 0 or 1 must print power form
	os<< "x^" <<m.exponent();
	if (m.exponent()== 1) // just print x
	os<<"x";	
	else //if it's 0 exponent print nothing
		os<<"";
	return os;
};
class polynomial{
	private:
		node* first;
		node* last;
		int length;
	public:
		polynomial(){
			first=0;
			last=first;
			length=0;		
		}
		//zeros out the polynomial
		void reset(){
			first=0;
			last=first;
			length=0;
		}
		node* getFirst(){
			return first;
		}
		//appends to the polynomial
		//i is the constant
		//j is the exponent
		void append(int i,int j){
			//inserts into new node
			node* m =  new node(i,j);
			//if empty first is intialized
			if (length==0){
				first=m;
				last=first;
				length++;
			}
			//just add on the end
			else{
			last->next()=m;
			last=m;
			length++;
			}
		}
	/*this method appropriately inserts the node
	in ascending order*/
		void insert(int i,int j){
			//empty just intialize
			if (length==0){
				node* m= new node (i,j);
				first=m;
				last=first;
				length++;
				return;
	
			}
			else 
				{
				node* m= new node (i,j);
				node* curr=first;
				node* prev=first;
				//preappend
				if(j>curr->exponent()){
					node* m= new node (i,j);
						m->next()=first;
						first=m;
						length++;
						return;
					}
			 while(curr){
			 	//exponents are the same
			 	//so add the two exponents
			 	if(curr->exponent()==j){
			 		curr->setConstant(curr->constant()+ i);
			 		return;
			 	}
			 	//exponent >curr
			 	//insert before it
			 	else if (j>curr->exponent()){
			 		node* m= new node (i,j);
			 		m->next()=curr;
			 		prev->next()=m;
			 		length++;
			 		return;
			 }
			 
			 else {
			 	prev=curr;
			 	curr=curr->next();
			 }
					
			}
			//at end of list
			//just add onto the end
			if(curr==0){
			node* m= new node (i,j);
			last->next()=m;
			last=m;
			length++;
		}
	}
	}
		polynomial  operator+ (polynomial& m){
			polynomial p;
			node* curr = first;
			node* currm=m.first;
			while(curr){
				if(!currm)
					break;
				while(currm){
					if(!curr)
						break;
					if(curr->exponent()==currm->exponent()){
					//just add the constant and append to the polynomial
						p.append(curr->constant()+currm->constant(),curr->exponent());
						currm=currm->next();
						curr=curr->next();
				}
					//the curr exponent is bigger so just append it
					else if(curr->exponent()>currm->exponent())	{
						//just append
						p.append(curr->constant(),curr->exponent());
						curr=curr->next();
					}
					else{
						//currm is bigger so append it
						p.append(currm->constant(),currm->exponent());
						currm=currm->next();
					}
						
				}	
			}
			//curr got to the end of the list
			if(currm){
				while(currm){
					p.append(currm->constant(),currm->exponent());
					currm=currm->next();
				}
			}
			//currm got to the end of the list
			else{
				while(curr){
					p.append(curr->constant(),curr->exponent());
					curr=curr->next();
				}
			}
			return p;
	}
	polynomial  operator- (polynomial m){
			polynomial p;
			node* curr = first;
			node* currm=m.first;
			while(curr){
				if(!currm)
					break;
				while(currm){
					if(!curr)
						break;
					if(curr->exponent()==currm->exponent()){
					//just add the constant and append to the polynomial
						if(curr->constant()-currm->constant()!=0)
							p.append(curr->constant()-currm->constant(),curr->exponent());
						currm=currm->next();
						curr=curr->next();
				}
					else if(curr->exponent()>currm->exponent())	{
						//just append
						p.append(curr->constant(),curr->exponent());
						curr=curr->next();
					}
					else{
						p.append(-1*currm->constant(),currm->exponent());
						currm=currm->next();
					}
						
				}	
			}
			if(currm){
				while(currm){
					p.append(currm->constant(),currm->exponent());
					currm=currm->next();
				}
			}
			else{
				while(curr){
					p.append(curr->constant(),curr->exponent());
					curr=curr->next();
				}
			}
			return p;
	}
	
	polynomial operator* (polynomial &m){
		polynomial p;
		node* curr=first;
		node* currm=m.first;
		//itertate through m polynomial
				//muiltply by each term pf this
		while(curr){
			while(currm){
				//add exponents
				int e=	curr->exponent()+currm->exponent();
				//mulitply constants
				int c= curr->constant()*currm->constant();
				//insert takes care of addtion
				//of multiplied terms
				p.insert(c,e);
				//go through polynomial m
				currm=currm->next();
			
			}
			/*goes back to begin of second 
			polynomial to muiltplied by next 
			term in first polyonimal
			*/
			currm=m.first;
			curr=curr->next();
		}
		return p;
	}
		friend ostream& operator <<  (ostream& os, polynomial m);
		
};

	ostream& operator << (ostream& os, polynomial m){
		if(m.getFirst()==0)
			return os;
		node* curr= m.getFirst();
		while(curr!=0){
		//call the node operator <<
		os<< *(curr);
		curr=curr->next();
		//no longer prints another plus if end of the list is reached
		if(curr!=0&&curr->constant()>0)
			os<< "+";
		//if the exponent is negative don't print a plus
		else if(curr!=0&&curr->constant()<0)
		os<<"";
		else 
			break;
	}
	return os;

	};

int main(){
	polynomial line1;
	polynomial line1r;
	polynomial line2;
	polynomial line2r;
	ofstream fout("output1.txt");
	//reading from the file
	const char* filename = "C:/Users/Miriam Schnoll/workspace/polynomials.txt";
	ifstream infile(filename);
	string s;
	int i;
	int j;
	//reads two lines and keeps track of it
	int lineat=1;
	while(infile.good()){
		getline(infile,s);
		
		stringstream t(s);
		t>>i;
		j=i;
		
		while(t>>i){
			//append to each polynomial
			//insert to each polynomial
			if (lineat%2==1){
				line1.append(j,i);
				line1r.insert(j,i);
			}
			else if (lineat%2==0){
				line2.append(j,i);
				line2r.insert(j,i);
			}
		
		t>>i;
		j=i;
		}
		if(lineat%2==0){
			//outputs polynomial to text file
			fout<<"Polynomial1 regular form:" <<"     " << line1<<endl;
			fout<<"Polynomial1 canonical form:"<<"    "<<line1r<<endl;
			fout<<"Polynomial2 regular form:" <<"     "<<line2<<endl;
			fout<<"Polynomial2 canonical form:"<<"    "<<line2r<<endl;
			fout<<"polynomial1 + polynomial2 = "<<"   "<<line1r+line2r<<endl;
			fout<<"polynomial1 - polynomial2 = "<<"   "<<line1r-line2r<<endl;
			fout<<"polynomial1 * polynomial2 = "<<"   "<<line1r*line2r<<endl;
			fout<<"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" <<endl;
			//resets polynomials for reuse in additional lines in file
			line1.reset();
			line1r.reset();
			line2.reset();
			line2r.reset();
			
		}
		lineat++;
			
			
	}
	
	fout.close();

	return 0;
}
