/**
 * Binary Node has data, right, and left
 * since it's part of a binary tree
 * @author Miriam Schnoll
 *Project 2
 */
public class BinaryNode{
	protected Comparable data;
	protected BinaryNode right;
	protected BinaryNode left;
	public BinaryNode(Comparable d){
		data=d;
		left=right=null;
		
	}

}
