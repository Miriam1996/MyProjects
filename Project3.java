/**
 * project 3 uses a hash table to store 
 * faculty and students
 * @author Miriam Schnoll
 *
 */
public class Project3 {
	public static void main (String args[]){
		// create a new student and faculty to insert
		SchoolPeople j= new Student("Miriam","Schnoll", "S12345678");
		SchoolPeople h = new Faculty ("Josef", "Svitak", "F12345678");
		//create a new hash map to store them
		HashMap map = new HashMap();
		//insert them
		map.insert(j);
		map.insert(h);
		//find them based in id
		Student l =(Student) map.find("S12345678");
		Faculty f = (Faculty) map.find ("F12345678");
		//print them
		System.out.println(l.toString());
		System.out.println(f.toString());
		//delete one based on id
		map.Delete("S12345678");
		
	}

}
