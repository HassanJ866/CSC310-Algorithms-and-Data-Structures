
import java.util.Scanner;
class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class BST2 {
	
	Node root;

	public BST2() {
		this.root = null;
	}

	public void insert(int id) {
		Node newNode = new Node(id);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (id < current.value) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}

	}

	public void delete(int id) {
		delete(root, id);
	}

	private Node delete(Node root, int id) {
		if (root == null)
			return null;
		if (id < root.value)
			root.left = delete(root.left, id);
		else if (id > root.value)
			root.right = delete(root.right, id);

		else if (root.left == null && root.right == null)
			return null;
		else if (root.left == null)
			root = root.right;
		else if (root.right == null)
			root = root.left;

		else {
			root.value = findMax(root.left).value;
			root.left = delete(root.left, root.value);
		}
		return root;
	}

	private Node findMax(Node root) {
		if (root == null)
			return null;
		else if (root.right == null)
			return root;
		else {
			return findMax(root.right);
		}
	}

	public void PreOrder(Node rt) {
		if (rt == null) {
			return;
		}
		
		System.out.printf("%s ", rt.value);
		PreOrder(rt.left);
		PreOrder(rt.right);

	}

	public static void main(String[] args) {

		BST2 tree = new BST2();
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] values = new int[n];

		for (int i = 0; i < values.length; i++) {
			values[i] = scan.nextInt();
		}

		tree.root = new Node(values[0]);
		for (int i = 1; i < values.length; i++) {
			tree.insert(values[i]);
		}

		Node rt = tree.root;
		tree.PreOrder(rt);	
		}

}
