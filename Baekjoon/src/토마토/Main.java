package 토마토;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] tomato;
	static int[] x = { 1, -1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static int answer = 0;
	static boolean[][] visited;
	static Queue<Position> q = new LinkedList<Position>();
	static Position ps;
	static int N;
	static int M;
	static List<Integer> l = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸 수

		tomato = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// String temp = st.nextToken();
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				l.add(tomato[i][j]);
			}
		}
		if (l.contains(0)) {
			visited = new boolean[N][M];
			bfs();
			check();
			System.out.println(answer);
		} else {
			System.out.println(0);
		}

	}

	static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1 && visited[i][j] == false) {
					q.add(new Position(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			ps = q.poll();
			answer = ps.day;
			for (int i = 0; i < 4; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];

				if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= M || visited[n_x][n_y] == true) {
					continue;
				}
				if (tomato[n_x][n_y] == -1 && tomato[n_x][n_y] == 1) {
					continue;
				} else {
					if (tomato[n_x][n_y] == 0 && visited[n_x][n_y] == false) {
						q.add(new Position(n_x, n_y, answer + 1));
						visited[n_x][n_y] = true;
						tomato[n_x][n_y] = 1;
					}
				}

			}
		}
	}

	static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					answer = -1;
				}
			}
		}
	}

}

class Position {
	int x;
	int y;
	int day;

	public Position(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
		// TODO 자동 생성된 생성자 스텁
	}
}
