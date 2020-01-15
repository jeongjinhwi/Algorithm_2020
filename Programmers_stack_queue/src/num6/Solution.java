package num6;
import java.util.*;
public class Solution {
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];      
        for(int i = 0; i<prices.length; i++){
        	int count = 0;
        	for(int j = i+1; j<prices.length; j++){
        		if(prices[i] <= prices[j]){
        			count++;
        		}else if(prices[i] > prices[j] && j != prices.length){
        			count++;
        			break;
        		}else if(prices[i] > prices[j] && j == prices.length){
        			break;
        		}
        	}
        	answer[i] = count;
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] prices = {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		for(int i = 0; i<prices.length; i++){
			System.out.println(result[i]);
		}
	}

}
