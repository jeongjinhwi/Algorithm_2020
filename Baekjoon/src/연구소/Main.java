package 연구소;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] virus;
	static int[][] lab;
	static boolean[][] visited;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static int wall = 3;
	static int answer;
	static int max = 0;
	static Queue<Position> q;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		virus = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
				lab[i][j] = virus[i][j];
			}
		}
		build_wall(wall);

		
		System.out.println(max);
	}
	public static int result(){
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0)
					count++;
			}
		}
		return count;
	}
	public static void build_wall(int usewall) {	//dfs()
		if (usewall == 0) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus[i][j] == 0) {
					virus[i][j] = 1;
					build_wall(usewall-1);
					virus[i][j] = 0;
				}

			}
		}
	}

	public static void bfs() {
		Position ps;
		q = new LinkedList<Position>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab[i][j] = virus[i][j];
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus[i][j] == 2 && visited[i][j] == false) {
					q.add(new Position(i, j));
					visited[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			ps = q.poll();
			for (int i = 0; i < 4; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= M) {
					continue;
				}
				if (visited[n_x][n_y] == true || lab[n_x][n_y] == 1) {
					continue;
				} else {
					if (visited[n_x][n_y] == false && lab[n_x][n_y] == 0) {
						visited[n_x][n_y] = true;
						lab[n_x][n_y] = 2;
						q.add(new Position(n_x, n_y));

					}
				}
			}
		}
		max = Math.max(max, result());
		visited = new boolean[N][M];
		
	}
}

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
