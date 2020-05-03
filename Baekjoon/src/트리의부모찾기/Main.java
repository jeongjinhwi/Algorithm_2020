package 트리의부모찾기;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] visit;
	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visit = new int[N+1];
		for(int i = 0; i <= N; i++){
			tree.add(new ArrayList<>());
		}
		for(int i = 0; i < N-1; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		bfs(1);
		for(int i = 2; i < visit.length; i++){
			System.out.println(visit[i]);
		}
	}
	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = 1;
		
		while(!q.isEmpty()){
			int parent = q.poll();
			for(int i : tree.get(parent)){
				if(visit[i] == 0){
					visit[i] = parent;
					q.add(i);
				}
			}
		}
	}

}
