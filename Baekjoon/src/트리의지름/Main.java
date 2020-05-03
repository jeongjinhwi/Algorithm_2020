package 트리의지름;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[] visit;
	static List<Edge>[] tree;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		tree = (List<Edge>[]) new LinkedList[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new LinkedList<Edge>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			while (true) {
				int p2 = Integer.parseInt(st.nextToken());
				if (p2 == -1) {
					break;
				}
				int w = Integer.parseInt(st.nextToken());
				tree[p1].add(new Edge(p2, w));

			}

		}
		int[] max_w = new int[N + 1];
		max_w = bfs(1);
		int start = 0;
		for (int i = 1; i < tree.length; i++) {
			if (max_w[start] < max_w[i]) {
				start = i;
			}
		}
		visit = new boolean[N + 1];
		max_w = bfs(start);
		for (int i = 1; i < tree.length; i++) {
			if (max_w[start] < max_w[i]) {
				start = i;
			}
		}

		System.out.println(max_w[start]);

	}

	public static int[] bfs(int start) {
		int[] max_w = new int[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visit[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int t = q.poll();
			visit[t] = true;

			for (Edge e : tree[t]) {
				int p2 = e.p2;
				int w = e.w;

				if (visit[p2] == false) {
					q.add(p2);
					max_w[p2] = max_w[t] + w;
				}
			}
		}

		return max_w;
	}

}

class Edge {
	int p2;
	int w;

	public Edge(int p2, int w) {
		this.p2 = p2;
		this.w = w;
	}
}