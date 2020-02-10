package num6;
import java.util.*;
public class Solution {
	 public static int solution(int n, int[][] costs) {
	        int answer = 0;
	        /*	//전체 연결이 되지 않는 코드
	        Arrays.sort(costs, (o1,o2)->Integer.compare(o1[2], o2[2]));
	        boolean[] visit = new boolean[n];
	        boolean check = true;
   
	        for(int i = 0; i < costs.length; i++){
	        	int start = costs[i][0];
	        	int end = costs[i][1];
	        	int weight = costs[i][2];
	        	for(int j = 0; j < visit.length; j++){
	        		if(visit[j] == false){
	        			check = false;
	        			break;
	        		}else{
	        			check = true;
	        		}
	        	}
	        	if(check == true){
	        		break;
	        	}
	        	if(visit[start] != true || visit[end] != true){
	        		visit[start] = true;
	        		visit[end] = true;
	        		answer += weight;
	        	}
	        	
	        }
	        return answer;
	        */
	        
	        int[][] position = new int[n][n];
	        for(int i = 0; i < costs.length; i++) {
	            position[costs[i][0]][costs[i][1]] = position[costs[i][1]][costs[i][0]] = costs[i][2];
	        }
	        boolean[] visit = new boolean[n];
	        List<Integer> connect = new ArrayList<>(n+1);
	        connect.add(0);
	        visit[0] = true;
	        while(connect.size() < n) {
	            int min = 1000000000;
	            int minIdx = 0;
	            for(int k = 0; k < connect.size(); k++) {
	                int i = connect.get(k);
	                for(int j = 0; j < n; j++) {
	                    if(!visit[j] && i != j && position[i][j] > 0 && position[i][j] < min) {
	                        min = position[i][j];
	                        minIdx = j;
	                    }
	                }
	            }
	            visit[minIdx] = true;
	            connect.add(minIdx);
	            answer += min;
	        }
	        return answer;
	        
	    }
	public static void main(String[] args) {
		int[][] cost = {{0,1,5},{0,2,2},{1,2,1},{1,3,1},{2,3,8}};
//		int[][] cost = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}};
		int[][] cost2 =  {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}};	//n = 6, 답 11
		int n = 6;
		System.out.println(solution(n, cost2));
 	}
}
