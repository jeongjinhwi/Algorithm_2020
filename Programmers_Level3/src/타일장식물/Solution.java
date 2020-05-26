package 타일장식물;

import java.util.*;

public class Solution {
	public static long solution(int N) {
		long answer = 0;
		Queue<Long> q = new LinkedList<Long>();
		ArrayList<Long> list = new ArrayList<>();
		q.add((long) 1);
		q.add((long) 1);
		if(N == 1){
			return q.poll();
		}else{
			for(int i = 0; i < N; i++){
				long pre = q.poll();
				long next = q.poll();
				list.add(pre);
				q.add(next);
				q.add(pre+next);
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		
		long a = list.get(0);
		long b = list.get(1);
		answer = ((2*a)+b)*2;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int N = 6;
		System.out.println(solution(N));
	}

}
