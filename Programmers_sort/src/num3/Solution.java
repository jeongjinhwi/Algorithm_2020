package num3;
import java.util.*;
public class Solution {
	public static int solution(int[] citations) {
		//어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.
        int answer = 0;
        int size = citations.length;
        
        /************역순 정렬***********/
        Integer[] cita = new Integer[size];
        for(int i = 0; i<size; i++){
        	cita[i] = citations[i];
        }
        Arrays.sort(cita,Collections.reverseOrder());
        /***********역순 정렬*************/
        Arrays.sort(citations);
        int h = 0;
        for(int i = 1; i<citations.length; i++){
        	h = citations[i];
        	int up = size - i;
        	if(up <= h){
        		answer = up;
        		break;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] cit = {3, 0, 6, 1, 5};
		int[] cit2 = {0,1,2,2,3,4};
		System.out.println(solution(cit));
	}

}
