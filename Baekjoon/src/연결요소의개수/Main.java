package 연결요소의개수;

import java.util.*;
import java.io.*;

public class Main {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int N, M;
	static boolean[] visited;
	static int count = 0;
	static int[][] data;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()) - 1;
			data[f][s] = 1;
            data[s][f] = 1;
		}
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);

	}

	public static void bfs(int x) {
		q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 0; j < N; j++) {
				if (data[temp][j] == 1 && visited[j] == false) {
					q.add(j);
					visited[j] = true;

				}
			}
		}

	}
}
