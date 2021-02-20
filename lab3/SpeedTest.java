import java.util.Random;
import java.util.Scanner;

public class SpeedTest {
	static class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	class Node1 {
		int data;
		Node1 left, right;

		Node1(int d) {
			data = d;
			left = right = null;
		}
	}

	static class BST {
		Node root;

		Node fill(int array[], int first, int last) {

			if (first > last) {
				return null;
			}

			int mid = (first + last) / 2;
			Node node = new Node(array[mid]);

			node.left = fill(array, first, mid - 1);

			node.right = fill(array, mid + 1, last);

			return node;
		}

		class Node {
			int key, height;
			Node left, right;

			Node(int d) {
				key = d;
				height = 1;
			}
		}

		static class AVLTree {

			Node root;

			int height(Node N) {
				if (N == null)
					return 0;

				return N.height;
			}

			int max(int a, int b) {
				return Math.max(a, b);
			}

			Node rightRotate(Node y) {
				Node x = y.left;
				Node T2 = x.right;

				x.right = y;
				y.left = T2;

				y.height = max(height(y.left), height(y.right)) + 1;
				x.height = max(height(x.left), height(x.right)) + 1;

				return x;
			}

			Node leftRotate(Node x) {
				Node y = x.right;
				Node T2 = y.left;

				y.left = x;
				x.right = T2;

				x.height = max(height(x.left), height(x.right)) + 1;
				y.height = max(height(y.left), height(y.right)) + 1;

				return y;
			}

			int getBalance(Node N) {
				if (N == null)
					return 0;

				return height(N.left) - height(N.right);
			}

			Node insert(Node node, int key) {

				if (node == null)
					return (new Node(key));

				if (key < node.key)
					node.left = insert(node.left, key);
				else if (key > node.key)
					node.right = insert(node.right, key);
				else
					return node;

				node.height = 1 + max(height(node.left), height(node.right));

				int balance = getBalance(node);

				if (balance > 1 && key < node.left.key)
					return rightRotate(node);

				if (balance < -1 && key > node.right.key)
					return leftRotate(node);

				if (balance > 1 && key > node.left.key) {
					node.left = leftRotate(node.left);
					return rightRotate(node);
				}

				if (balance < -1 && key < node.right.key) {
					node.right = rightRotate(node.right);
					return leftRotate(node);
				}

				return node;
			}

			void InOrder(Node node) {
				if (node != null) {
					InOrder(node.left);
					System.out.print(node.key + " ");
					InOrder(node.right);
				}
			}

			static class Main {
				public static void main(String[] args) {
					final long startTime = System.nanoTime();
					final long startTime2 = System.nanoTime();
					Random r = new Random();
					BST tree = new BST();
					int arr[] = new int[10];
					for (int i = 0; i < arr.length; i++) {
						arr[i] = r.nextInt();
					}
					tree.root = tree.fill(arr, 0, arr.length - 1);
					final long duration = System.nanoTime() - startTime;
					System.out.println(duration / 1000000000.0 + " seconds");

					AVLTree t = new AVLTree();
					int n = r.nextInt(1) + 10000;
					System.out.println("Size is: " + n);
					for (int i = 0; i < n; i++) {
						int x = r.nextInt();
						t.root = t.insert(t.root, x);
					}
					final long duration2 = System.nanoTime() - startTime2;
					System.out.println(duration2 / 1000000000.0 + " seconds");
				}
			}
		}
	}
}
//BST:
//a[100] - 0.00110 sec
//a[1000] - 0.0014950 sec
//a[10000] - 0.002643801 sec

//AVL:
//a[100] - 0.003198205 sec
//a[1000] - 0.004145803 sec
//a[10000] - 0.0082747 sec