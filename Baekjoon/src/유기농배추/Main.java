package 유기농배추;

import java.util.*;

import java.io.*;

public class Main {
	static int loop;
	static int N, M, T;
	static int[][] farm;
	static boolean[][] visited;
	static int[] x = {-1,1,0,0};
	static int[] y = {0,0,-1,1};
	static int answer;
	static Queue<Position> q = new LinkedList<Position>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		loop = Integer.parseInt(st.nextToken());
		for (int l = 0; l < loop; l++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			answer = 0;
			farm = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				int x_temp = Integer.parseInt(st.nextToken());
				int y_temp = Integer.parseInt(st.nextToken());
				farm[y_temp][x_temp] = 1;
			}
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(farm[i][j] == 1 && visited[i][j] == false){
						q.add(new Position(i, j));
						visited[i][j] = true;
						bfs(i,j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
	static void bfs(int x_t, int y_t){
		Position ps;
		while(!q.isEmpty()){
			ps = q.poll();
			for (int i = 0; i < 4; i++) {
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];

				if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= M || visited[n_x][n_y] == true) {
					continue;
				}
				if (farm[n_x][n_y] == 0) {
					continue;
				} else {
					if (farm[n_x][n_y] == 1 && visited[n_x][n_y] == false) {
						q.add(new Position(n_x, n_y));
						visited[n_x][n_y] = true;
					}
				}

			}
		}
	}
}
class Position{
	int x; 
	int y;
	public Position(int x, int y) {
		// TODO 자동 생성된 생성자 스텁
		this.x = x;
		this.y = y;
	}
}
