/*
 * Author : Patricia Terol
 * Project: BSTs
 */
 
public class Node {
	private Node leftChild; // the pointer to the left child
	private Node rightChild; // the pointer to the right child
	private Node parent; // the pointer to the parent
	private String info; // the information stored on the node
	private int key; // the key stored on the node

	/**
	 * Method to create a node object with the given information.
	 * 
	 * @param information
	 *            The information to be stored on the node.
	 */
	public Node(int key, String information) {
		setInfo(information);
		setKey(key);
	}

	/**
	 * Method to get the key of the node.
	 * 
	 * @return The integer value of the key in that node.
	 */
	public int getKey() {
		return this.key;
	}

	/**
	 * Method to set the key of that node to the given integer.
	 * 
	 * @param key
	 *            The integer value to be stored on the key of the node.
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Method to get the child to the left.
	 * 
	 * @return The node stored as the left children.
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Method to set the left child to the given one.
	 */
	public void setLeftChild(Node node) {
		this.leftChild = node;
	}

	/**
	 * Method to get the child to the left.
	 * 
	 * @return The node stored as the left children.
	 */
	public Node getRightChild() {
		return this.rightChild;
	}

	/**
	 * Method to set the left child to the given one.
	 */
	public void setRightChild(Node node) {
		this.rightChild = node;
	}

	/**
	 * Method to get the information stored on a node.
	 * 
	 * @return The information stored.
	 */
	public String getInfo() {
		return this.info;
	}

	/**
	 * Method to set the information stored on the node to the new given one.
	 * 
	 * @param info
	 *            The given information to be stored.
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Method to get the parent of the given node.
	 * 
	 * @return The node containing the parent of the current node.
	 */
	public Node getParent() {
		return this.parent;
	}

	/**
	 * Method to set the parent of the node to the given one.
	 * 
	 * @param node
	 *            The node to be linked as the parent of the current node.
	 */
	public void setParent(Node node) {
		this.parent = node;
	}

	/**
	 * Method to check if the node has at least one children.
	 * 
	 * @return True if it has children, false otherwise.
	 */
	public boolean hasChildren() {
		if (this.rightChild == null && this.leftChild == null) {
			return false;
		}
		return true;
	}
}
