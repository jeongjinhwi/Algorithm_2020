package num3;
import java.util.*;
public class Solution {
	 public int solution(String[][] clothes) {
	        //hashmap사용, key에는 이름, value에는 종류 입력
				Map<String, Integer> list = new HashMap<String, Integer>();
		        int answer = 1;
		        
		        for(int i = 0; i<clothes.length; i++){
		        	if(!list.containsKey(clothes[i][1]))
		        		list.put(clothes[i][1], 1);
		        	else{
		        		list.put(clothes[i][1], list.get(clothes[i][1])+1);
		        	}
		        		
		        }
//		        입을 수 있는 옷 종류의 수는 각 종류별로 선택할지 안 할지 여부(+1)를 포함하여 아래와 같은 방식으로 구할 수 있습니다.
//		        (A종류 옷 가지수 + 1)*(B종류 옷 가지수 + 1)*(C종류 옷 가지수 + 1) - 1
//		        마지막의 -1은 아무것도 선택하지 않은 경우는 없어야하므로 제외 해준 것입니다.
		        for (int value : list.values()) {
		            answer*=(value+1);
		        }
		        answer-=1;
		        
		        return answer;
	    }
}
