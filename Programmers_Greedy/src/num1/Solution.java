package num1;
import java.util.*;
public class Solution {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] all_st = new int[n];
        for(int i = 0; i<all_st.length; i++){
        	all_st[i] = 1;
        }
        for(int i = 0; i<reserve.length; i++){
        	all_st[reserve[i]-1]++;
        }
        for(int i = 0; i<lost.length; i++){
        	all_st[lost[i]-1]--;
        }
        for(int i = 0; i<all_st.length; i++){		//ó��, ������ index�� 0���� Ȯ���ϴ� ���ǹ� �߰� ���־����.
        	if(i!=0 && all_st[i] == 0 && all_st[i-1] == 2){
        		all_st[i]++;
        		all_st[i-1]--;
        	}else if(i!=all_st.length-1 && all_st[i] == 0 && all_st[i+1] == 2){
        		all_st[i]++;
        		all_st[i+1]--;
        	}
        }
    	for(int i = 0; i<all_st.length; i++){
    		if(all_st[i]!=0){
    			answer++;
    		}
    	}
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int n = 3;					//��ü�л���
		int[] lost = {1,2};			//�������� �л�
		int[] reserve = {2,3};	//������ ü������ ������ �л� ��ȣ
		
		System.out.println(solution(n, lost, reserve));
	}

}
