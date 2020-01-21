package num2;
import java.util.*;

public class Solution {
	 public static int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        Queue<Integer> flour = new PriorityQueue<Integer>(Comparator.reverseOrder());	//최대 힙
	        
	        int index = 0;
	        for(int i = 0; i<k; i++){
	        	 if(index < dates.length && i == dates[index]){
	                 flour.add(supplies[index]);
	                 index++;
	        	 }

	             if(stock == 0) {
	                 stock += flour.poll();
	                 answer++;
	             }
	             stock -= 1;
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int st = 4;						//공장에 남아있는 밀가루 수량
		int[] date = {4,10,15};			//밀가루 공급일정
		int[] sup = {20,5,10};			//해당 시점에 공급 가능한 밀가루 수량
		int k = 30;						//원래 공장으로 부터 공급받을 수 있는 시점
		System.out.println(solution(st, date, sup, k));
		
	}

}
