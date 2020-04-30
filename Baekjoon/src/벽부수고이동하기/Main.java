package 벽부수고이동하기;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int wall[][];
	static int visit[][];
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, 1, -1 };
	static Queue<Position> q = new LinkedList<Position>();
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			for (int j = 0; j < M; j++) {
				wall[i][j] = num.charAt(j)-'0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		
		if (answer != -1) {
			System.out.println(answer);
		} else {
			System.out.println(answer);
		}
	}

	public static void bfs(int tx, int ty) {
		Position p;
		q.add(new Position(tx, ty, 1, 0));
		visit[tx][ty] = 0;
		while(!q.isEmpty()){
			p = q.poll();
			if(p.x == N-1 && p.y == M-1){
				answer = p.dis;
				break;
			}
			for(int i = 0; i < 4; i++){
				int nx = p.x+x[i];
				int ny = p.y+y[i];
				
				if(nx<0 || ny<0|| nx>=N ||ny>=M)
					continue;
				if(visit[nx][ny]<=p.bro) 
					continue;
				
				
				if(wall[nx][ny]==0) {
					visit[nx][ny] = p.bro;
					q.add(new Position(nx,ny,p.dis+1,p.bro));
				}
				else {
					if(p.bro==0) {
						visit[nx][ny] = p.bro+1;
						q.add(new Position(nx,ny,p.dis+1,p.bro+1));
					}
				}
			}
		}
	}

}

class Position {
	int x, y, dis, bro;

	public Position(int x, int y, int dis, int bro) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.bro = bro;
	}
}
