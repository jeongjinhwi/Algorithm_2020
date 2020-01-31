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
        for(int i = 0; i<all_st.length; i++){		//처음, 마지막 index가 0인지 확인하는 조건문 추가 해주어야함.
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
		// TODO 자동 생성된 메소드 스텁
		int n = 3;					//전체학생수
		int[] lost = {1,2};			//도난당한 학생
		int[] reserve = {2,3};	//여벌의 체육복을 가져온 학생 번호
		
		System.out.println(solution(n, lost, reserve));
	}

}
