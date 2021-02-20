
import java.util.*;

class Node1 {
	int data;
	Node1 left, right;

	Node1(int d) {
		data = d;
		left = right = null;
	}
}

public class BST {
	Node1 root;

	boolean isBalanced(Node1 node) {
		int hl;
		int hr;

		if (node == null)
			return true;

		hl = height(node.left);
		hr = height(node.right);

		if (Math.abs(hl - hr) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;

		return false;
	}

	int height(Node1 node) {
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}

	public Node1 insert(Node1 root, int key) {

		if (root == null) {
			root = new Node1(key);
		}

		if (key < root.data)
			root.left = insert(root.left, key);
		else if (key > root.data)
			root.right = insert(root.right, key);

		return root;
	}

	public static void main(String args[]) {
		BST tree = new BST();
		;
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		for (int j = 0; j < size; j++) {
			int in = scan.nextInt();
			tree.root = tree.insert(tree.root, in);
		}
		if (tree.isBalanced(tree.root))
			System.out.println("isAvl\n");
		else
			System.out.println("notAvl\n");
		scan.close();
	}
}