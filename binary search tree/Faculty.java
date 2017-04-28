/**
 * Project 2
 * @author Miriam Schnoll
 * Faculty class has first name, last name, and faculty id 
 */
import java.util.Comparator;
public class Faculty  implements Comparable<Faculty> {
	private String firstName;
	private String lastName;
	private String facultyId;

	public Faculty(String firstN, String lastN, String fid) {
		//fid must be  digits and start with F
		if (firstN.equals(" ") || lastN.equals(" ") || fid.length() != 9 || fid.charAt(0) != 'S')
			throw new IllegalArgumentException("invalid student");
		firstName = firstN;
		lastName = lastN;
		facultyId = fid;
	}

	/**
	 * this method compares faculty based on last name and if last name is the
	 * same it compares first name
	 * 
	 * @param s
	 * @return
	 */
	public int compareTo(Faculty s) {
		// first compares last names
		int c = lastName.compareTo(s.lastName);
		// if equal check first name
		if (c == 0)
			c = firstName.compareTo(s.firstName);
		return c;
	}
	/**
	 * method to get first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

	}

	public String getFacultyID() {
		return facultyId;

	}
	public String toString(){
		String t = firstName + " " + lastName + " " + facultyId;
		return t;
	}

	public void setFacultyID(String fid) {
		if (fid.charAt(0) != 'F' || fid.length() != 9)
			throw new IllegalArgumentException("invalid id");
		facultyId = fid;
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

	/**
	 * this method compares to faculty if the ids are the same then it's the
	 * same faculty
	 * 
	 * @param f1
	 *            is faculty to compare
	 * @return
	 */
	public boolean equals(Faculty f1) {
		if (facultyId.equals(f1.facultyId))
			return true;
		else
			return false;
	}





}
