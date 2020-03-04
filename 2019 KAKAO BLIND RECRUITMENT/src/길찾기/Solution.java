package ��ã��;

import java.util.*;

class Solution {
	//�ٽ� Ǯ���
	static int index = 0;

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		List<Node> list = new ArrayList<Node>();

		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		Collections.sort(list, new Comparator<Node>() { //y�� ���������� ���� y�� ������ x�� ���������� ����
			@Override
			public int compare(Node n1, Node n2) {
				// TODO �ڵ� ������ �޼ҵ� ����
				if (n1.y > n2.y) {
					return -1;
				} else if (n1.y < n2.y) {
					return 1;
				} else {
					if (n1.x > n2.x) {
						return 1;
					} else if (n1.x < n2.x) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
		
		Node root = list.get(0);
		answer = new int[2][list.size()];

		for (int i = 1; i < list.size(); i++) {
			addNode(root, list.get(i));
		}

		preorder(answer, root);
		index = 0;
		postorder(answer, root);

		return answer;
	}

	static void addNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null) {
				parent.left = child;
			} else {
				addNode(parent.left, child);
			}
		} else {
			if (parent.right == null) {
				parent.right = child;
			} else {
				addNode(parent.right, child);
			}
		}
	}

	static void preorder(int[][] arr, Node root) { // ������ȸ

		if (root != null) {
			arr[0][index++] = root.num;
			preorder(arr, root.left);
			preorder(arr, root.right);
		}
	}

	static void postorder(int[][] arr, Node root) { // ������ȸ
		if (root != null) {
			postorder(arr, root.left);
			postorder(arr, root.right);
			arr[1][index++] = root.num;
		}
	}

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		solution(nodeinfo);
	}
}

class Node {
	int x;
	int y;
	int num;
	Node left;
	Node right;

	public Node(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}