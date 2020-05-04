package 트리순회;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Tree tree = new Tree();
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			char c1 = st.nextToken().charAt(0);
			char c2 = st.nextToken().charAt(0);
			char c3 = st.nextToken().charAt(0);
			tree.add(c1, c2, c3);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
	}

}

class Node {
	Node left, right;
	char data;

	public Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	public void add(char data, char leftData, char rightData) {
		if (root == null) {
			if (data != '.')
				root = new Node(data);
			if (leftData != '.')
				root.left = new Node(leftData);
			if (rightData != '.')
				root.right = new Node(rightData);
		} else
			search(root, data, leftData, rightData);
	}

	private void search(Node root, char data, char leftData, char rightData) {
		if (root == null)
			return;
		else if (root.data == data) {
			if (leftData != '.')
				root.left = new Node(leftData);
			if (rightData != '.')
				root.right = new Node(rightData);
		} else {
			search(root.left, data, leftData, rightData);
			search(root.right, data, leftData, rightData);
		}
	}

	public void preorder(Node root) {
		System.out.print(root.data);
		if (root.left != null)
			preorder(root.left);
		if (root.right != null)
			preorder(root.right);
	}

	public void inorder(Node root) {
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.data);
		if (root.right != null)
			inorder(root.right);
	}

	public void postorder(Node root) {
		if (root.left != null)
			postorder(root.left);
		if (root.right != null)
			postorder(root.right);
		System.out.print(root.data);
	}
}