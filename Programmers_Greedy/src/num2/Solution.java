package num2;
import java.util.*;
public class Solution {
	public static int solution(String name) {
        int answer = 0;	//A�� 65, Z�� 91 ���ĸ��� �� 26��
        char A = 65;
        char Z = 91;
        int not_A = name.length() -1;
        for(int i = 0; i<name.length(); i++){
        	char name_al = name.charAt(i);
        	int temp = Math.abs(Z-name_al);				//13�� �������� ����
        	if(temp > name_al-A){
        		answer += name_al-A;
        	}else{
        		answer += temp;
        	}
        	if(name_al == 'A'){
        		int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() && name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                int tmp = (i-1)*2 + (name.length() -1 -i - countA);
                if(not_A > tmp){
                	not_A = tmp;
                }
        	}
        	
        }
        answer += not_A; 
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		String name="JEROEN";
		System.out.println(solution(name));
	}
}
