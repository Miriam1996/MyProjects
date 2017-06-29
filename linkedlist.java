/**
 * 
 * @author Miriam Schnoll 
 * Project 3
 * 	  
 *linkedlist is a linked list containing nodes that contain SchoolPeople object
 */
public class  linkedlist {
	private Node first;
	private Node last;
	private int length;
	/**
	 * first make into a new date node with data  as null
	 */
	public linkedlist(){
		first = new Node (null); // creates a dummy node for first
		last = first; // last is set to equal first because first is currently the last on list
		length=0;	
	}
	
	/**
	 * 
	 * @return the first Node in a linkedlist
	 */
	protected Node getFirst() { // gets the first Node in a linkedlist
		return first;
	}
	/**
	 * method gets last Node in linkedlist
	 * @return the last Node in a linkedlist
	 */
	protected Node getLast(){
		return last;
	}	
	/**
	 * this method append a Node to the end of the linkedlist
	 * a new Node is created to hold the SchoolPeople object 
	 * last is then pointed to that new Node
	 * The Node then becomes last
     * @param t SchoolPeople appends to the end of the list
	 */
	protected void Append (SchoolPeople t){
		Node n  = new Node(t); // create new node to store date
		last.next =n; // the last node will point to the new node created called n
		last = n; // last node will now be set to n because that is now the end of the list
		length++;
	}
	/**
	 * this method deletes if the id equals the id passed in
	 * @param t is the id
	 */
	
	protected void Delete (String t){

		Node curr =first;
		//runs through list
		while(curr!=null){
			if (last==null)
				break;
			//if the id equals the data in the node
			//delete it by making was curr
			//point to the what curr.next was
			if  (curr.next.data.getID().equals(t)){
				curr.next=curr.next.next;
				length--;
				break;
			}
			curr=curr.next;
		}
	}
	
	
	

	} 