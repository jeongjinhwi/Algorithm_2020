package 가운데를말해요;
import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> minq = new PriorityQueue<>();
		PriorityQueue<Integer> maxq = new PriorityQueue<>((o1,o2)-> o2-o1);
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int data = Integer.parseInt(st.nextToken());;
			if(minq.size() == maxq.size()){
				maxq.add(data);
			}else{
				minq.add(data);
			}
			if(!minq.isEmpty() && !maxq.isEmpty()){
				if(maxq.peek() > minq.peek()){
					int temp = minq.poll();
					maxq.add(temp);
					minq.add(maxq.poll());
				}
			}
			System.out.println(maxq.peek());
		}
		
	}

}
