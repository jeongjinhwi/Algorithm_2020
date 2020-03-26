import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Parent_Child> list = new ArrayList<Parent_Child>();
	static Parent_Child pc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int result = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list.add(new Parent_Child(i + 1, Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pa = Integer.parseInt(st.nextToken());
			int ch = Integer.parseInt(st.nextToken());
			result += count(pa, ch);
		}
	}

	public static int count(int pa, int ch) {
		int answer = 0;
		for(int i = 0; i <list.size(); i++){
			int n_p = list.get(i).p;
			int n_x = list.get(i).c;
			if(n_p == pa && n_x == ch && n_p == 0){
				continue;
			}else{
				answer++;
			}
			
		}
		return answer;
	}
}

class Parent_Child {
	public int p;
	public int c;

	public Parent_Child(int p, int c) {
		this.p = p;
		this.c = c;
	}
}
