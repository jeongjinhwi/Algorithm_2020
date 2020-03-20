package 나이트의이동;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] chess;
	static boolean[][] visitied;
	static int[] x = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] y = { 1, -1, 2, -2, 2, -2, 1, -1 };

	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int loop = Integer.parseInt(st.nextToken());
		int c_x = 0;
		int c_y = 0;
		int t_x = 0;
		int t_y = 0;
		for (int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			chess = new int[N][N];
			visitied = new boolean[N][N];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				if (j == 0) {
					c_x = Integer.parseInt(st.nextToken());
					c_y = Integer.parseInt(st.nextToken());
					chess[c_x][c_y] = 1;
				} else if (chess[c_x][c_y] == 1 && j != 0) {
					t_x = Integer.parseInt(st.nextToken());
					t_y = Integer.parseInt(st.nextToken());
					if (chess[t_x][t_y] == 1) {
						System.out.println(0);
						break;
					} else {
						chess[t_x][t_y] = 2;
						bfs(c_x, c_y, t_x, t_y);
						System.out.println(result);
						result = 0;
					}
				}
			}
		}
	}

	public static void bfs(int c_x, int c_y, int t_x, int t_y) {
		Queue<Position> q = new LinkedList<Position>();
		Position ps;
		q.add(new Position(c_x, c_y, 0));
		visitied[c_x][c_y] = true;
		while (!q.isEmpty()) {
			ps = q.poll();
			result = ps.count;
			for (int i = 0; i < x.length; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				if(n_x == t_x && n_y == t_y){
					result = ps.count+1;
					return;
				}
				if(n_x >=0 && n_y >=0 && n_x < N && n_y < N && visitied[n_x][n_y] == false){
					q.add(new Position(n_x, n_y, result+1));
					visitied[n_x][n_y] = true;
				}
			}
		}
	}

}

class Position {
	int x;
	int y;
	int count;

	public Position(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}