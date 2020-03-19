package 토마토2;

import java.util.*;

import java.io.*;

public class Main {
	static int N, M, T;
	static int[][][] tomato;
	static int[] x = { -1, 1, 0, 0, 0, 0 };
	static int[] y = { 0, 0, -1, 1, 0, 0 };
	static int[] z = { 0, 0, 0, 0, -1, 1 };
	static Queue<Position> q = new LinkedList<Position>();
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		tomato = new int[T][N][M];

		for (int x = 0; x < T; x++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int data = Integer.parseInt(st.nextToken());
					tomato[x][i][j] = data;
					if (tomato[x][i][j] == 1) {
						q.add(new Position(i, j, x, 0));
					}
				}
			}
		}
		bfs();

		System.out.println(check());

	}
	public static int check(){
		for (int x = 0; x < T; x++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[x][i][j] == 0) {
						return -1;
					}
				}
			}
		}
		return result;
	}

	public static void bfs() {
		Position ps;
		while (!q.isEmpty()) {
			ps = q.poll();
			result = ps.day;
			for (int i = 0; i < 6; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				int n_z = ps.z + z[i];
				if (n_x >= 0 && n_y >= 0 && n_x < N && n_y < M && n_z >= 0 && n_z < T && tomato[n_z][n_x][n_y] == 0) {
					q.add(new Position(n_x, n_y, n_z, result + 1));
					tomato[n_z][n_x][n_y] = 1;
				}
			}
		}
	}

}

class Position {
	int x;
	int y;
	int z;
	int day;

	public Position(int x, int y, int z, int day) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}
