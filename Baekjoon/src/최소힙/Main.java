package 弥家赛;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long x;

	public static void main(String[] args) throws IOException {
		// TODO 磊悼 积己等 皋家靛 胶庞
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Long> q = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
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
