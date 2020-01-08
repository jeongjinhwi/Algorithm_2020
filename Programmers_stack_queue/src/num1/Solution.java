package num1;
import java.util.*;
public class Solution {
	
	public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i = 1; i<heights.length; i++){
        	for(int j = i-1; j>=0; j--){
	        	if(heights[j] > heights[i]){		//left > right
	        		answer[i] = j+1;
	        		break;
	        	}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] heights = {6,9,5,7,4};
		System.out.println(solution(heights));
		
	}

}
