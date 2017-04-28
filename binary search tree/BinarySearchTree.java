/**
 * Project 2
 * this class is a binary search tree
 * @author Miriam Schnoll
 */
import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree {
	private BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	/**
	 * public insert method calls private method that accesses the nodes
	 * 
	 * @param d
	 *            what is inserted into tree
	 */
	public void Insert(Comparable d) {
		root = Insert(d, root);
	}
	/**
	 * call private method to delete a node
	 * @param d
	 */

	public void Delete(Comparable d) {
		root = Delete(d, root);

	}

	public void Inorder() {
		Inorder(root);
	}
	/**
	 * 
	 * @param t
	 */

	private static void Inorder(BinaryNode t) {
		if (t != null) {
			Inorder(t.left);
			System.out.println(t.data.toString());
			Inorder(t.right);

		}
	}

	/**
	 * deletes a node from the tree
	 * @param d
	 * @param t
	 * @return
	 */
	private static BinaryNode Delete(Comparable d, BinaryNode t) {
		if (t != null) {
			if (d.compareTo(t.data) < 0)
				t.left = Delete(d, t.left);
			else if (d.compareTo(t.data) > 0)
				t.right = Delete(d, t.right);
			else {
				if (t.left == null)// no left child
					return t.right;
				else if (t.right == null)// no right child
					return t.left;
				else {// two children
					t.data = FindMin(t.right);
					t.right = Delete(t.data, t.right);
				}
			}

		}
		return t;
	}

	/**
	 * finds minimum on binary tree
	 * 
	 * @param t
	 * @return
	 */
	private static Comparable FindMin(BinaryNode t) {
		while (t != null) {
			t = t.left;
		}
		return t.data;
	}

	/**
	 * this method inserts 
	 * a comparable object in the tree
	 * @param d Comparable object
	 * @param t root is passed in
	 * @return a binary node
	 */

	private static BinaryNode Insert(Comparable d, BinaryNode t) {
		if (t != null) {
			if (d.compareTo(t.data) < 0)
				t.left = Insert(d, t.left);
			else
				t.right = Insert(d, t.right);

		} else //there's no root
			t = new BinaryNode(d);
		return t;
	}

}
