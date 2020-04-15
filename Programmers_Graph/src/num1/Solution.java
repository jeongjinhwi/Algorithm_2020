package num1;

import java.util.*;

public class Solution {
	public static int solution(int n, int[][] edge) {
		/* 인접 리스트 */
		int answer = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < edge.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		int a, b;
		for (int[] node : edge) {
			a = node[0];
			b = node[1];
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int[] count = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[0] = visited[1] = true;
		int now;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int v : list.get(now)) {
				if (!visited[v]) {
					count[v] = count[now] + 1;
					visited[v] = true;
					q.add(v);
				}
			}
		}
		int max = 0;
		for (int cnt : count) {
			if (max < cnt) {
				max = cnt;
				answer = 1;
			} else if (max == cnt)
				answer++;
		}
		return answer;
		
		/*
		int answer = 0;
		boolean[] visit = new boolean[n + 1];
		boolean[][] connect = new boolean[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++) {
			connect[edge[i][0]][edge[i][1]] = connect[edge[i][1]][edge[i][0]] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		List<Integer> nextNodes = new ArrayList<>();
		q.add(1);
		visit[0] = visit[1] = true;
		while (true) {
			answer = q.size();
			while (!q.isEmpty()) {
				int node = q.poll();
				for (int j = 1; j <= n; j++) {
					if (!visit[j] && connect[node][j]) {
						nextNodes.add(j);
						visit[j] = true;
					}
				}
			}
			if (nextNodes.isEmpty()) {
				break;
			}
			q.addAll(nextNodes);
			nextNodes.clear();
		}
		return answer;
		*/

	}

	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(6, edge));
	}

}
