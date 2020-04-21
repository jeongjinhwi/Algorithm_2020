package 최대힙;

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int x;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			if(x != 0){
				q.add(x);
			}else if(x == 0 && !q.isEmpty()){
				System.out.println(q.poll());
			}else{
				System.out.println(0);
			}
		}
	}

}
