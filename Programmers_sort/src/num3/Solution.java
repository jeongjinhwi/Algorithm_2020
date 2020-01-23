package num3;
import java.util.*;
public class Solution {
	public static int solution(int[] citations) {
		//� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index�Դϴ�.
        int answer = 0;
        int size = citations.length;
        
        /************���� ����***********/
        Integer[] cita = new Integer[size];
        for(int i = 0; i<size; i++){
        	cita[i] = citations[i];
        }
        Arrays.sort(cita,Collections.reverseOrder());
        /***********���� ����*************/
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
		// TODO �ڵ� ������ �޼ҵ� ����
		int[] cit = {3, 0, 6, 1, 5};
		int[] cit2 = {0,1,2,2,3,4};
		System.out.println(solution(cit));
	}

}
