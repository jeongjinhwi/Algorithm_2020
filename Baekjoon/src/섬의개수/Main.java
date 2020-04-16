package 섬의개수;
import java.util.*;
import java.io.*;
public class Main {
	static int[][] island;
	static boolean[][] visit;
	static int[] x = {-1,-1,-1,0,0,1,1,1};	//7개
	static int[] y = {-1,0,1,-1,1,-1,0,1};
	static Queue<Position> q;
	static int m, n;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true){
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(n != 0 && m !=0){
				island = new int[n][m];
				visit = new boolean[n][m];
				for(int i = 0; i < n; i++){
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < m; j++){
						island[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				q = new LinkedList<Position>();
				for(int i = 0; i < n; i++){
					for(int j = 0; j < m; j++){
						if(island[i][j] == 1 && visit[i][j] == false){
							bfs(i, j);
							answer++;
						}
					}
				}
				System.out.println(answer);
				
				
			}else if(n == 0 && m == 0){
				break;
			}
		}
	}
	public static void bfs(int px, int py){
		visit[px][py] = true;
		q.add(new Position(px, py));
		Position ps;
		while(!q.isEmpty()){
			ps = q.poll();
			for(int i = 0; i < x.length; i++){
				int n_x = ps.x + x[i];
				int n_y = ps.y + y[i];
				if(n_x >= 0 && n_y >= 0 && n_x <n && n_y < m && visit[n_x][n_y] == false && island[n_x][n_y] == 1){
					q.add(new Position(n_x, n_y));
					visit[n_x][n_y] = true;
					
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
