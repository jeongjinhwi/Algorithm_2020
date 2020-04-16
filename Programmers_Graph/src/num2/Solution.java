package num2;

import java.util.*;

public class Solution {
	public static int solution(int n, int[][] results) {
		int max = 450000;
		int answer = 0;
		int[][] result = new int[n + 1][n + 1];
		int win;
		int lose;
		for (int[] re : result) {
			Arrays.fill(re, max);
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (i == j) {
					result[i][j] = 0;
				}
			}
		}

		for (int[] sc : results) {
			win = sc[0];
			lose = sc[1];
			result[win][lose] = 1;
		}
		for (int k = 1; k <= n; k++) {	//win -> lose
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (result[i][j] > result[i][k] + result[k][j]) {
						result[i][j] = result[i][k] + result[k][j];
					}
				}
			}
		}
		boolean[] visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (result[i][j] == max && result[j][i] == max) {
					visit[i] = true;
					break;
				}
			}
		}
		for(int i = 1; i < visit.length; i++){
			if(!visit[i]){
				answer ++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		System.out.println(solution(n, results));
	}

}
