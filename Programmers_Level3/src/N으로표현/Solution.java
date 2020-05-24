package N으로표현;
import java.util.*;

public class Solution {
	static int result = -1;
	public static int solution(int N, int number) {
		int answer = 0;
		answer = dfs(N,number,0,0);
		
		return answer;
	}
	
	public static int dfs(int N, int number, int count, int prev){

		int t_N = N;
		if(count > 8){
			result = -1;
			return -1;
		}
		if(number == prev && (result == -1 || result > count)){
			result = count;
			return result;
		}
		for(int i = 0; i < 8-count; i++){
			dfs(N, number, count+i+1, prev-t_N);
			dfs(N, number, count+i+1, prev+t_N);
			dfs(N, number, count+i+1, prev*t_N);
			dfs(N, number, count+i+1, prev/t_N);
			
			t_N = temp(t_N, N);
					
		}
		
		return result;
	}
	public static int temp(int number, int N){
		return number*10+N;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}

}
