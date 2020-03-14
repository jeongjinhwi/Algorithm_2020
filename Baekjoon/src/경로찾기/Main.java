package 경로찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
	static int N;
	static int[][] dist;
	static int[][] answer;
	static boolean[] visited;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dist = new int[N][N];
		// answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int data = Integer.parseInt(st.nextToken());
				dist[i][j] = data;
				// answer[i][j] = data;
			}
		}
		bfs();
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print(dist[i][j] + " ");
			}
		}

	}

	static void bfs() {
		for (int i = 0; i < N; i++) {
			q = new LinkedList<Integer>();
			visited = new boolean[N];
			q.add(i);

			while (!q.isEmpty()) {
				int ps = q.poll();
				for (int j = 0; j < N; j++) {
					if (dist[ps][j] == 1 && visited[j] == false) {
						q.add(j);
						dist[i][j] = 1;
						visited[j] = true;
					}
				}
			}
		}
	}
}
