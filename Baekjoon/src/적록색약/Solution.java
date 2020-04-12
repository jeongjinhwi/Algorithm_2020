package 적록색약;

import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	static boolean[][] visited;
	static Queue<Position> q = new LinkedList<Position>();
	static int[] x = {-1,1,0,0};
	static int[] y = {0,0,-1,1};
	static int count = 0;
	public static void main(String[] args) throws IOException {
		char[][] color;
		char[][] color2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		color = new char[N][N];
		color2 = new char[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < N; j++){
				color[i][j] = temp.charAt(j);
				if(temp.charAt(j) == 'R'){
					color2[i][j] = 'G';
				}else{
					color2[i][j] = temp.charAt(j);
				}
			}
		}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(visited[i][j] == false){					
					bfs(i,j,color);
					count++;
				}
			}
		}
		System.out.print(count);
		count = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(visited[i][j] == false){					
					bfs(i,j,color2);
					count++;
				}
			}
		}
		System.out.println(" "+count);
	}
	public static void bfs(int s_x, int s_y, char[][] color){
		visited[s_x][s_y] = true;
		q.add(new Position(s_x, s_y));
		Position ps;
		while(!q.isEmpty()){
			ps = q.poll();
			char temp = color[ps.x][ps.y];
			for(int i = 0; i < 4; i++){
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				if(n_x >= 0 && n_y >= 0 && n_x < N && n_y < N && visited[n_x][n_y] == false && color[n_x][n_y] == temp){
					q.add(new Position(n_x, n_y));
					visited[n_x][n_y] = true;
					
				}
			}
		}
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
