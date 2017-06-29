/**
 * @author Miriam Schnoll Project 3 class Node
 */
// Lab Section F
public class Node {
	protected SchoolPeople data;
	protected Node next;

	/**
	 * 
	 * @param d is SchoolPeople object
	 */
	public Node(SchoolPeople d) {
		data = d;
		next = null;
	}
}
