/**
 * Project 1 
 * this class is a stack
 * @author Miriam Schnoll
 *
 */
public class Stack extends Object {
	private Node top;
	public Stack() {
	}
	/**
	 * this method checks if a stack is empty
	 * @return
	 */
	public boolean isEmpty(){
	return top==(null);
	}
	public Widgets peak (){
		if (isEmpty())
			throw new NullPointerException("Stack is empty");
			
		return top.data;
	}
	/**
	 * method pops top Widget on stack
	 * @return oldpeak when you pop stack
	 * the old top is returned
	 */
		public Widgets pop (){
			if (isEmpty())
				throw new NullPointerException("Stack is empty");
			Widgets oldpeak = top.data;
			top= top.next;
			return oldpeak;
			
		}
		/**
		 * method puts widget on top of stack
		 * @param d is the Widget being put on the stack
		 * 
		 */
		public void push (Widgets d){
			//create new node to hold newtop
			Node newtop = new Node(d);
			// the newtop points to the current top
			newtop.next = top;
			// top is set to the new top
			top = newtop;
		}
	}
