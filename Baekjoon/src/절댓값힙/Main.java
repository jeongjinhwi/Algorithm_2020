package Àý´ñ°ªÈü;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO ÀÚµ¿ »ý¼ºµÈ ¸Þ¼Òµå ½ºÅÓ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1 == abs2){
				if(o1 > o2){
					return 1;
				}else{
					return -1;
				}
			}else{
				return abs1-abs2;
			}
		});
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int data = Integer.parseInt(st.nextToken());
			if(data == 0 && q.isEmpty()){
				System.out.println(0);
			}else if(data == 0 && !q.isEmpty()){
				System.out.println(q.poll());
			}else{
				q.add(data);
			}
		}
	}

}
