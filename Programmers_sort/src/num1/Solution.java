package num1;
import java.lang.reflect.Array;
import java.util.*;
public class Solution {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
        	int start = commands[i][0];
        	int end = commands[i][1];
        	int index = commands[i][2];
        	int[] temp = new int[end-start+1];
        	System.arraycopy(array, start-1, temp, 0, end-start+1);
        	//System.out.println(temp);
        	Arrays.sort(temp);
        	answer[i] = temp[index-1];
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] ar = {1, 5, 2, 6, 3, 7, 4};
		int[][] com ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(ar,com);
	}

}
