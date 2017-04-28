
/**
 * @author Miriam Schnoll
 * Project 2
 * Student class has first name
 * last name, student id 
 */
import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private String studentId;

	public Student(String firstN, String lastN, String sid) {
		//id must start with S and end be length 9
		if (firstN.equals(" ") || lastN.equals(" ") || sid.length() != 9 || sid.charAt(0) != 'S')
			throw new IllegalArgumentException("invalid student");
		firstName = firstN;
		lastName = lastN;
		studentId = sid;
	}
/**
 * this method compares students based on last name
 * if last name is the same compares first
 */
	public int compareTo(Student s) {
		// first compares last names
		int c = lastName.compareTo(s.lastName);
		// if equal check first name
		if (c == 0)
			c = firstName.compareTo(s.firstName);
		return c;

	}

	/**
	 * this method shows if a student is equal
	 * 
	 * @param s
	 * @return
	 */

	public boolean equals(Student s) {
		// the id is equal then the student
		if (studentId.equals(s.studentId))
			return true;
		else
			return false;
	}

	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

	}

	public String getStudentID() {
		return studentId;

	}

	public void setFirstName(String fname) {
		if (fname == " ")
			throw new IllegalArgumentException("invalid name");
		firstName = fname;
	}

	public void setLastName(String lname) {
		if (lname == " ")
			throw new IllegalArgumentException("invalid name");
		lastName = lname;
	}

	public void setStudentID(String sid) {
		if (sid.charAt(0) != 'S' || sid.length() != 9)
			throw new IllegalArgumentException("invalid id");
		studentId = sid;

	}
/**
 * this method return the student information as a string
 */
	public String toString() {
		String t = firstName + " " + lastName + " " + studentId;
		return t;
	}

}
