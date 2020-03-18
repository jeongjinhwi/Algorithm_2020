package 안전영역;

import java.util.*;

import java.io.*;

public class Main {
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, 1, -1 };
	static int N;
	static int[][] data;
	static boolean[][] visited;
	static ArrayList<Integer> result = new ArrayList<>();
	static int max = 0;
	static Queue<Position> q = new LinkedList<Position>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int d = Integer.parseInt(st.nextToken());
				data[i][j] = d;
				max = Math.max(d, max);
			}
		}
		for (int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int z = 0; z < N; z++) {
				for (int j = 0; j < N; j++) {
					if (data[z][j] > i && visited[z][j] == false) {
						bfs(z, j, i);
						count++;
					}
				}
			}
			result.add(count);
		}
		System.out.println(Collections.max(result));
	}

	public static void bfs(int t_x, int t_y, int dep) {
		Position ps;
		q.add(new Position(t_x, t_y));
		visited[t_x][t_y] = true;

		while (!q.isEmpty()) {
			ps = q.poll();
			for (int i = 0; i < 4; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= N) {
					continue;
				}
				if (visited[n_x][n_y] == true || data[n_x][n_y] <= dep) {
					continue;
				} else {
					visited[n_x][n_y] = true;
					q.add(new Position(n_x, n_y));
				}
			}
		}
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