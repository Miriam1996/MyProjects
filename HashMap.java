/**
 * Project 3 This class is an array of linked lists the array is of size 1000 it
 * is mapped by %1000 of the id of the school people
 * 
 * @author Miriam Schnoll
 *
 */

public class HashMap {
	linkedlist[] array = new linkedlist[1000];

	public HashMap() {
		//intialize all spots in array as linked lists
		for (int i = 0; i < 1000; i++)
			array[i] = new linkedlist();
	}

	/**
	 * this method inserts new SchoolPeople
	 * 
	 * @param t
	 *            is the SchoolPeople being inserted
	 */
	public void insert(SchoolPeople t) {
		// id is converted to an integer
		int j = t.toInt() % 1000;
		// mapped to spot in array based on id
		array[j % 1000].Append(t);
	}
/**
 * this method deletes based the id
 * convert id to an integer
 * @param t is the id
 */
	public void Delete(String t) {
		//convert id to int
		int j = Integer.parseInt(t.substring(1, t.length())) % 1000;
		//finds linked list the SchoolPeople is and then it deletes it from the list
		// it calls the delete method from the linked list class
		array[j % 1000].Delete(t);
	}
/**
 * this method finds SchoolPeople based in id 
 * @param t is the id string
 * @return
 */
	public SchoolPeople find(String t) {
		//converts string id to integer
		int j = Integer.parseInt(t.substring(1, t.length())) % 1000;
		//goes to the linked list that the id is mapped to
		Node curr = array[j % 1000].getFirst().next;
		//returns linked list
		while (curr != null) {
			//if it equals the id return it
			if (curr.data.getID().equals(t))

				return curr.data;
			curr = curr.next;
		}
		// it was not found 
		throw new IllegalArgumentException("not found");

	}

}
