package num3;
import java.util.*;
public class Solution {
	 public int solution(String[][] clothes) {
	        //hashmap���, key���� �̸�, value���� ���� �Է�
				Map<String, Integer> list = new HashMap<String, Integer>();
		        int answer = 1;
		        
		        for(int i = 0; i<clothes.length; i++){
		        	if(!list.containsKey(clothes[i][1]))
		        		list.put(clothes[i][1], 1);
		        	else{
		        		list.put(clothes[i][1], list.get(clothes[i][1])+1);
		        	}
		        		
		        }
//		        ���� �� �ִ� �� ������ ���� �� �������� �������� �� ���� ����(+1)�� �����Ͽ� �Ʒ��� ���� ������� ���� �� �ֽ��ϴ�.
//		        (A���� �� ������ + 1)*(B���� �� ������ + 1)*(C���� �� ������ + 1) - 1
//		        �������� -1�� �ƹ��͵� �������� ���� ���� ������ϹǷ� ���� ���� ���Դϴ�.
		        for (int value : list.values()) {
		            answer*=(value+1);
		        }
		        answer-=1;
		        
		        return answer;
	    }
}
