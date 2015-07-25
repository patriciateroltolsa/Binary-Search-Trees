/*
 * Author : Patricia Terol
 * Project: BSTs
 */
 
public interface Tree {

	public void insert(Node node);

	// insert the node into the tree

	public void delete(Node node);

	// delete the node from the tree

	public void insert(int key, String value);

	// insert the node into the tree

	public void delete(int key);

	// delete the node from the tree

	public String search(int key);

	// find the Key key

	public void inorderTreeWalk(Node x);

	// print the tree

	public Node findMinimum(Node node);

	// find the minimum of the tree;

	public Node findMaximum(Node node);
	// find the maximum of the tree

}
