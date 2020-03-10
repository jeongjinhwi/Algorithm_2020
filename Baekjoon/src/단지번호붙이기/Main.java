package 단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] x = { 1, -1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 }; // 동, 서, 남, 북
	static int[][] data;
	static int N;
	static int count = 0;
	static Queue<Position> q = new LinkedList<Position>();
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < N; j++) {
				data[i][j] = temp.charAt(j) - '0';
			}
		}

		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j] == 1 && visited[i][j] == false) {
					bfs(i, j, visited);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static void bfs(int q_x, int q_y, boolean[][] visited) {
		q.add(new Position(q_x, q_y));
		visited[q_x][q_y] = true;
		int t_count = 1;
		while (!q.isEmpty()) {
			Position ps = q.poll();
			for (int i = 0; i < 4; i++) {
				int n_x = ps.data_x + x[i];
				int n_y = ps.data_y + y[i];
				if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= N || visited[n_x][n_y] == true) {
					continue;
				}
				if (data[n_x][n_y] == 0) {
					continue;
				} else {
					if (data[n_x][n_y] == 1 && visited[n_x][n_y] == false) {
						q.add(new Position(n_x, n_y));
						visited[n_x][n_y] = true;
						t_count++;
					}
				}

			}
		}
		list.add(t_count);
	}

}

class Position {
	int data_x;
	int data_y;

	public Position(int x, int y) {
		// TODO 자동 생성된 생성자 스텁
		this.data_x = x;
		this.data_y = y;
	}
}
