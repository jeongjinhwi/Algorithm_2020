package 바이러스;

import java.util.*;
import java.io.*;

public class Main {
	static int N, l;
	static int[][] com;
	static boolean[] visit;
	static Queue<Integer> q;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		com = new int[N+1][N+1];
		visit = new boolean[N+1];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			com[p1][p2] = 1;
			com[p2][p1] = 1;
		}
		
		for (int i = 1; i <=N; i++) {
			for(int j = 1; j <= N; j++){
				if(visit[i] == false && com[i][j] == 1 && i == 1){
					dfs(i);
				}
			}
		}
		System.out.println(count);

	}

	public static void dfs(int cx) {
		q = new LinkedList<>();
		q.add(cx);
		visit[cx] = true;
		while(!q.isEmpty()){
			int x = q.poll();
			for(int i = 1; i <= N; i++){
				if(visit[i] == false && com[x][i] == 1){
					q.add(i);
					visit[i] = true;
					count++;

				}
			}
		}
	}

}
