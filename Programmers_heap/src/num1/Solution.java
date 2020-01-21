package num1;
import java.util.*;
public class Solution {
	public static int solution(int[] scoville, int K) {
		Queue<Integer> pri_q = new PriorityQueue<Integer>();	//우선순위 큐 사용
        int answer = 0;
        for(int t : scoville){
        	pri_q.add(t);
        }
        int new_sco = 0;
        
        while(pri_q.peek() <= K){	//최소 힙이므로
        	if(pri_q.size() == 1){	
        		return -1;		
        	}else{
        		int p1 = pri_q.poll();
        		int p2 = pri_q.poll();
        		new_sco = p1+(p2*2);
        		pri_q.add(new_sco);
        		answer++;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] sc = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(sc, k));
	}

}
