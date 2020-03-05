package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringBuilder sb_dfs = new StringBuilder();
	static StringBuilder sb_bfs = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 정점의 번호

		LinkedList<Integer>[] list = new LinkedList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			list[node1].add(node2);
			list[node2].add(node1);
			Collections.sort(list[node1]);
			Collections.sort(list[node2]);
		}
		boolean[] dfsvisitied = new boolean[N + 1];
		boolean[] bfsvisitied = new boolean[N + 1];
		dfs(list, V, dfsvisitied);
		bfs(list, V, bfsvisitied);
		System.out.println(sb_dfs);
		System.out.println(sb_bfs);

	}

	public static void dfs(LinkedList<Integer>[] list, int V, boolean[] visited) { // 깊이우선, 재귀
		if (visited[V]) {
			return;
		} else {
			visited[V] = true;
			sb_dfs.append(V + " ");
			for (int i = 0; i < list[V].size(); i++) {
				int nextNode = list[V].get(i);
				dfs(list, nextNode, visited);
			}
		}
	}

	public static void bfs(LinkedList<Integer>[] list, int V, boolean[] visitied) { // 넓이우선, 큐
		Queue<Integer> result = new LinkedList<Integer>();
		result.add(V);
		while(!result.isEmpty()){
			int node = result.poll();
			if (visitied[node]) {
				continue;
			}else{
				visitied[node] = true;
				sb_bfs.append(node + " ");
				for (int i = 0; i < list[node].size(); i++) {
					int nextNode = list[node].get(i);
					result.add(nextNode);
				}
			}
		}
	}

}
