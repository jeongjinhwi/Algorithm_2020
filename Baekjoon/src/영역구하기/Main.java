package 영역구하기;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[][] area;
	static boolean[][] visitied;
	static ArrayList<Integer> ar = new ArrayList<>();
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static Queue<Position> q = new LinkedList<Position>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		area = new int[M][N];
		visitied = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int l_x = Integer.parseInt(st.nextToken());
			int l_y = Integer.parseInt(st.nextToken());
			int r_x = Integer.parseInt(st.nextToken());
			int r_y = Integer.parseInt(st.nextToken());
			for (int j = l_y; j < r_y; j++) {
				for (int z = l_x; z < r_x; z++) {
					area[j][z]++;
				}
			}
		}
		int temp = 0;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(area[i][j] == 0 && visitied[i][j] == false){
					bfs(i,j);
					temp++;
				}
			}
		}
		System.out.println(temp);
		Collections.sort(ar);
		for(int i = 0; i < ar.size(); i++){
			System.out.print(ar.get(i)+" ");
		}
	}

	static void bfs(int p_x, int p_y) {
		Position ps;
		q.add(new Position(p_x, p_y));
		visitied[p_x][p_y] = true;
		int count = 1;
		while(!q.isEmpty()){
			ps = q.poll();
			for(int i = 0; i < 4; i++){
				int n_x = ps.x+x[i];
				int n_y = ps.y+y[i];
				
				if(n_x < 0 || n_y < 0 || n_x >= M || n_y >=N)
					continue;
				if(visitied[n_x][n_y] == true || area[n_x][n_y] != 0){
					continue;
				}else{
					q.add(new Position(n_x, n_y));
					visitied[n_x][n_y] = true;
					count++;
				}
			}
		}
		ar.add(count);
	}

}
class Position{
	int x;
	int y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}