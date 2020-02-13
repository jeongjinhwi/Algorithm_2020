package num2;
import java.util.*;
public class Solution {
	static boolean[][] connect;
	 public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        connect = new boolean[n][n];
	        for(int i = 0; i < n; i++){
	        	if(connect[i][i] == false){
	        		dfs(n, computers, i);
	        		answer++;
	        	}
	        }
	        return answer;
	    }
	
	public static void dfs(int n, int[][] computers, int index){
		for(int i = 0; i < n; i++){
        	if(computers[index][i] == 1 && connect[index][i] == false){
        		connect[index][i] = true;
        		connect[i][index] = true;
        		dfs(n, computers, i);
        	}
        }
	}
	 
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 3;
		int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int [][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n, computers));
	}

}
