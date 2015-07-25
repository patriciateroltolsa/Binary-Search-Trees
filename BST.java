/*
 * Author : Patricia Terol
 * Project: BSTs
 */
 
public class BST implements Tree {
	private Node head; // The first node of the tree (head).

	/**
	 * Method to construct a BST, initializing its head.
	 */
	public BST() {
		// initialize the tree
		head = new Node(0, null);
	}

	/**
	 * Method to search a node with the given key and return its information.
	 * 
	 * @param key
	 *            The integer value of the key of the node to be searched.
	 * 
	 * @return The information associated with the given key on the tree.
	 */
	@Override
	public String search(int key) {
		// start searching calling it at the head of the tree
		return search(key, this.head);
	}

	/**
	 * Method to search a key on a tree given a current node.
	 * 
	 * @param key
	 *            The integer value of the key being searched.
	 * @param currentNode
	 *            The current node to look in.
	 * @return The information associated with the key given or null if not
	 *         found.
	 */
	public String search(int key, Node currentNode) {
		// the subtree starting at currentNode is empty
		if (currentNode == null || currentNode.getInfo() == null) {
			return null;
		}
		// the current node contains the given key
		if (key == currentNode.getKey()) {
			return currentNode.getInfo();
		}
		// the node containing the key is in the left subtree of the of the tree
		// starting at currentNode
		if (key < currentNode.getKey()) {
			return search(key, currentNode.getLeftChild());
		} else {
			// the node containing the key is in the right subtree of the of the
			// tree starting at currentNode
			return search(key, currentNode.getRightChild());
		}
	}

	/**
	 * Method to insert a node into the BST.
	 * 
	 * @param node
	 *            The node to be inserted.
	 */
	@Override
	public void insert(Node node) {
		// start the search of the place to be inserted by calling the method on
		// the head
		insert(node, this.head);
		return;
	}

	/**
	 * Method to insert a new node on the BST with the given information.
	 * 
	 * @param key
	 *            The integer value of the key to be inserted on the new node.
	 * 
	 * @param value
	 *            The information to be stored associated with the key.
	 */
	@Override
	public void insert(int key, String value) {
		// start the search of the place to be inserted by calling the method on
		// the head
		insert(new Node(key, value), this.head);
	}

	/**
	 * Method to insert a node into the subtree started on the current node
	 * given.
	 * 
	 * @param newNode
	 *            The node to be inserted.
	 * @param currentNode
	 *            The current node, or head of the new subtree.
	 */
	private void insert(Node newNode, Node currentNode) {
		// if the current node is empty
		if (currentNode == null || currentNode.getInfo() == null) {
			currentNode.setKey(newNode.getKey());
			currentNode.setInfo(newNode.getInfo());
			currentNode.setLeftChild(newNode.getLeftChild());
			currentNode.setParent(newNode.getParent());
			currentNode.setRightChild(newNode.getRightChild());
		}
		// the node to be inserted is smaller than the current head, so the node
		// is to be inserted on the left subtree of the current tree
		if (currentNode.getKey() > newNode.getKey()) {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(newNode);
			} else {
				insert(newNode, currentNode.getLeftChild());
			}
		} else if (currentNode.getKey() < newNode.getKey()) {
			// the node to be inserted is smaller than the current head, so the
			// node
			// is to be inserted on the left subtree of the current tree
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(newNode);
			} else {
				insert(newNode, currentNode.getRightChild());
			}
		}
		return;
	}

	/**
	 * Method to delete the given node.
	 * 
	 * @param node
	 *            The node to be deleted from the tree.
	 */
	@Override
	public void delete(Node node) {
		delete(head, node.getKey());
	}

	/**
	 * Method to delete the node with the given key.
	 * 
	 * @param key
	 *            The integer value of the key of the node to be deleted from
	 *            the tree.
	 */
	@Override
	public void delete(int key) {
		delete(head, key);
		return;
	}

	/**
	 * Method to delete the node with the given key on the subtree starting at
	 * the given node.
	 * 
	 * @param node
	 *            The node the subtree starts in.
	 * @param key
	 *            The integer value of the key of the node to be deleted from
	 *            the subtree starting at node.
	 */
	private void delete(Node node, int key) {
		// if the tree starting at node is empty
		if (node == null || node.getInfo() == null) {
			return;
		}
		// if the given key is smaller than the head key, the node is going to
		// be on the left subtree
		if (key < node.getKey()) {
			delete(node.getLeftChild(), key);
			return;
		}
		// if the given key is smaller than the head key, the node is going to
		// be on the left subtree
		if (key > node.getKey()) {
			delete(node.getRightChild(), key);
		}
		// if the node contains the given key and is not a leave
		if (node.hasChildren()) {
			if (node.getLeftChild() != null) {
				int max = findMaximum(node.getLeftChild()).getKey();
				node.setKey(max);
				delete(node.getLeftChild(), max);
			} else {
				int min = findMinimum(node.getRightChild()).getKey();
				node.setKey(min);
				delete(node.getRightChild(), min);
			}

		} else {
			// if node contains the given key and is a leaf
			node = null;
		}
		return;
	}

	/**
	 * Method to print the tree in order.
	 */
	@Override
	public void inorderTreeWalk(Node x) {
		if (x != null) {
			inorderTreeWalk(x.getLeftChild());
			System.out.println(x.getKey() + "---" + x.getInfo());
			inorderTreeWalk(x.getRightChild());
		}
		return;
	}

	/**
	 * Method to find the minimum key number stored on the tree.
	 * 
	 * @param node
	 *            The node the subtree to be searched starts on.
	 */
	@Override
	public Node findMinimum(Node node) {
		// if the tree starting at node is empty
		if (node == null || node.getInfo() == null) {
			return null;
		}
		// if the node does not contain a left children
		if (node.getLeftChild() == null) {
			return node;
		}
		// otherwise keep looking on the left subtree
		return findMinimum(node.getLeftChild());
	}

	/**
	 * Method to find the maximum key number stored on the tree.
	 * 
	 * @param node
	 *            The node the subtree to be searched starts on.
	 */
	@Override
	public Node findMaximum(Node node) {
		// if the tree starting at node is empty
		if (node == null || node.getInfo() == null) {
			return null;
		}
		// if the node does not contain a right children
		if (node.getRightChild() == null) {
			return node;
		}
		// otherwise keep looking on the right subtree
		return findMinimum(node.getRightChild());
	}

	/**
	 * Method to calculate the depth of the tree starting at the given node.
	 * 
	 * @param node
	 *            The head of the tree or subtree to calculate the depth of.
	 * @return The integer value of the depth of the tree or subtree.
	 */
	public int calculateDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			// calculate the length of one subtree
			int leftDepth = calculateDepth(node.getLeftChild());
			// calculate the length of the other subtree
			int rightDepth = calculateDepth(node.getRightChild());
			// compare and take the biggest path
			if (leftDepth > rightDepth) {
				return leftDepth + 1;
			} else {
				return rightDepth + 1;
			}
		}
	}

	/**
	 * Method to get the head of the BST
	 * 
	 * @return The first node or head of the BST.
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * Method to set the head of the BST to the given node.
	 * 
	 * @param head
	 *            The node to be set as the head of the tree.
	 */
	public void setHead(Node head) {
		this.head = head;
	}

}
