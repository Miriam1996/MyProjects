/**
 * this class is a super class for faculty and students
 * students have first and last name and id
 * @author Miriam Schnoll
 *
 */
public class  SchoolPeople {
	protected String firstName;
	protected String lastName;
	protected String Id;
	public SchoolPeople(String fname, String lname, String id){
		if (fname.equals(" ") || lname.equals(" ") || id.length() != 9 || id.charAt(0) != 'S' && id.charAt(0)!='F')
			throw new IllegalArgumentException("invalid school person");
		firstName=fname;
		lastName=lname;
		Id=id;
	}
	public String getID(){
		return Id;
	}
	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

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
	public int toInt(){
		return Integer.parseInt( this.Id.substring (1, Id.length()));
		
	}
	public String toString() {
		String t = firstName + " " + lastName + " " + Id;
		return t;
	}

}
