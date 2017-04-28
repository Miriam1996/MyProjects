/**
 * @author Miriam Schnoll
 * Project 2
 * using two binary trees for student and faculty
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project2 {
	public static void main (String [] args){
		//two binary trees one for students and one for faculty
		BinarySearchTree student = new BinarySearchTree();
		BinarySearchTree faculty = new BinarySearchTree();
		try{
		//reads in textfiles	
		File inputFile = new File("student.txt");
		File input1File= new File ("faculty.txt");
		Scanner in = new Scanner(inputFile);
		Scanner in1 = new Scanner (input1File);
		//spilt line by spaces
		String [] splited = new String [5];
		//reads text file of students
		while (in.hasNextLine()) {
		String line = in.nextLine();
		splited = line.split(" ");
		//puts into student values
		Student s = new Student(splited[0], splited[1],splited[2]);
		//inserts student into binary tree
		student.Insert(s);
		}
		//prints students out in order
		student.Inorder();
		//reads text file of faculty
		while (in1.hasNextLine()) {
			String line = in1.nextLine();
			splited = line.split(" ");
			Faculty f = new Faculty (splited[0], splited[1],splited[2]);
			faculty.Insert(f);
			}
		faculty.Inorder();
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
		}

}
