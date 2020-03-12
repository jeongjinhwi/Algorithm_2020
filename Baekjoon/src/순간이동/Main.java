package 순간이동;

import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int max = 100000;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 칸 수
		M = Integer.parseInt(st.nextToken()); // 세로 칸 수
		int[] dist = new int[max];
		visit = new boolean[max];
		q.add(N);
		visit[N] = true;
		bfs(dist);
		System.out.println(dist[M]);
	}

	static void bfs(int[] dist) {
		while (!q.isEmpty()) {
			int data = q.poll();
			if(data -1 >= 0){
				if(visit[data-1] == false){
					q.add(data-1);
					visit[data-1] = true;
					dist[data-1] = dist[data]+1;
				}
			}
			if(data +1 < max){
				if(visit[data+1] == false){
					q.add(data+1);
					visit[data+1] = true;
					dist[data+1] = dist[data]+1;
				}
			}
			if(data *2 < max){
				if(visit[data*2] == false){
					q.add(data*2);
					visit[data*2] = true;
					dist[data*2] = dist[data]+1;
				}
			}
		}

	}

}
