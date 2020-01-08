package num2;
import java.util.*;

//알고리즘 다시 확인해볼 것

public class Solution {
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> wait_truck = new LinkedList<Integer>();
	        Queue<Integer> ing_truck = new LinkedList<Integer>();
	        Queue<Integer> after_truck = new LinkedList<Integer>();
	        
	        for(int i = 0; i< truck_weights.length; i++){
	        	wait_truck.add(truck_weights[i]);
	        }
	        int w = 0;
	        
	        while(true){
	        	int new_truck = 0;
	        	w = w+new_truck;
	        	if(wait_truck.peek() != null){
		        	for(int i = 0; i<bridge_length; i++){
		        		if(wait_truck.peek() != null){
		        			if((w+wait_truck.peek()) <= weight){
			        			new_truck = wait_truck.poll();
			        			w = w+new_truck;
			        			ing_truck.add(new_truck);
			        			answer++;
		        			}else if((w+wait_truck.peek()) >= weight){
		        				answer++;
		        			}else{
		        				answer++;
		        			}
		        		}else if(wait_truck.peek() == null){
		        			answer++;
		        		}
		        		
		        	}
		        	w=w-ing_truck.peek();
		        	after_truck.add(ing_truck.poll());
	        	}else if(wait_truck.peek() == null && after_truck.size() == truck_weights.length){
	        		answer++;
	        		return answer;
	        	}
	        	
		        //answer++;
	        	
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int br = 100;
		int we = 100;
		int[] truck = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(br, we, truck));
	}

}
