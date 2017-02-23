#Miriam Schnoll 
#December 8, 2016
#this program reads integers and puts them in an array, prints the array, and prints the sum of the elements in the array
# my code would like this if it were in c++
#include <iostream>
#using namespace std;
#int main () {
#int myArray[10];
#int sum=0;
#int x;
# for (int i=0; i<10; i++) {
# cout << "Enter an integer to store in element " << i << " " <<endl;
#cin >> x;
# myArray[i] =x;
# sum += myArray[i];
#}
#for (int i=0; i<10; i++) 
# cout << "Element " << i+1 << of myArray contains: " << a[i] << endl;
#cout << "The sum of the 10 elements in myArray is: " << sum << endl;
#return 0;
#}
#$t0 holds the adress of the array
#$t1 was not used
#$t2 holds the size of the array being 10 integers
#$t3 gets the address of the array and continues to loop through array
#$t4 is used to loop through what index the array is at
#$t5 holds the value being read when moved from $v0
#$t6 was not used
#$t7 gets value inside the array
#$t8 holds the  total sum of the array
#$a0 is used print things out
#$v0 is used for syscall to read stuff in and print stuff out

		.data
myArray: 	.space 40
A:		.asciiz "Enter an integer to store in element "
B: 		.asciiz " of array myArray: \n"
iterator:	.word 0
size:   	.word 10
prompt: 	.asciiz "The sum of the 10 elements of array MyArray is: "
printing: 	.asciiz	"Element "
printing2:	.asciiz  " of array myArray contains: "
newln:		.asciiz 	"\n"	
index: 		.word 0

		.text
main:	la $t0, myArray #stores address of myArray
	lw $t1, iterator #stores the indexes when transfering the array until 10
	lw $t2, size #the size of myArray is 10 
	lw $t4, index #the index number to be printed
	move $t3, $t0 #move begining array into $t3
loop:	
	#prints A letting user know to input a number
	la, $a0, A
	li, $v0, 4
	syscall
	#prints out what number in array
	move $a0, $t4
	li $v0, 1
	syscall
	# add colon and new line
	la $a0, B
	li, $v0, 4
	syscall
	#will read in intergers 
	li $v0, 5 #reading in 
	syscall 	
	# put read in interger into array 
	move $t5, $v0
	#move $t3, $t0
	sw $t5, 0($t3)
	addi $t3, $t3, 4
	#increasing iterator to ask for next element
	addi $t4,$t4, 1
	 beq   $t4, $t2, endwhile 
	 #keep loop through as long as you haven't read in all 10 integers
	j loop
	endwhile:
	#printing array
	#zero all registers to be reused
	move $t5, $zero
	move $t4, $zero
	move $t3, $zero
	move $t3, $t0
	move $t8, $zero
printarray:
	#zeros out $t7
	move $t7, $zero
	
 	# prints Element
 	la $a0, printing 
 	li $v0, 4
 	syscall
 	#prints index number
 	move $a0, $t4
 	li $v0,1
 	syscall
 	#prints of array myArray contains:
 	la $a0, printing2
 	li $v0, 4
 	syscall 
 	#puts value from array into $t7	
	lw $t7,0($t3)
	#print value in array
	move $a0, $t7
	li $v0, 1
	syscall
	# gets the sum
	addu $t8, $t8, $t7
	#printing of new line
	la $a0, newln
	li $v0, 4
	syscall
	#sll $t3, $t4,2 #multiplying by 4 using left shift twice
	#go to next spot in array
	addi $t3, $t3,4
	#increaing index
 	addi $t4, $t4,1 #add one to index
	beq $t4, $t2, end #keep looping if not all elements have been printing
	j printarray #jumps to begining of loop
	end:
	# reset $t3 to zero
	
printsum:	
		# prints prompt which is the sum of the array is
		li $v0, 4
		la $a0, prompt 
		syscall
		# prints total sum
		move $a0, $t8
		li $v0,1
		syscall
		#print a new line
		la $a0, newln
		li $v0, 4
		syscall	
		#end of program
		li $v0,10
		syscall
	
	
