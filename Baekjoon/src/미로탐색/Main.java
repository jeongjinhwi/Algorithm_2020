package ¹Ì·ÎÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N= 0;
	static int M = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String data = st.nextToken();
			for (int j = 0; j < M; j++) {
				maze[i][j] = data.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		bfs(0, 0, visited, maze);
		System.out.println(maze[N-1][M-1]);

	}

	public static void bfs(int x, int y, boolean[][] visited, int[][] maze){
		Queue<Position> result = new LinkedList<Position>();
		result.add(new Position(x,y));
		while(!result.isEmpty()){
			Position ps = result.poll();
			for(int i = 0; i < 4; i++){
				int next_x = ps.x+dx[i];
				int next_y = ps.y+dy[i];
				if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M){
					continue;
				}
				if(visited[next_x][next_y] == true || maze[next_x][next_y] == 0){
					continue;
				}
				visited[next_x][next_y] = true;
				result.add(new Position(next_x, next_y));
				maze[next_x][next_y] = maze[ps.x][ps.y]+1;
			}
				
		}
	}
}

class Position {
	int x;
	int y;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}