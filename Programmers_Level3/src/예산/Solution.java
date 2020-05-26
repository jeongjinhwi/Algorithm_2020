package 예산;

import java.util.*;

public class Solution {
	public static int solution(int[] budgets, int M) {
		int answer = 0;
		Arrays.sort(budgets);
		long result = 0;
		int min = 0;
		int max = budgets[budgets.length - 1];
		int center = 0;

		while (min <= max) {
			result = 0;
			center = (min + max) / 2;
			for (int t : budgets) {
				if (t >= center) {
					result += center;
				} else {
					result += t;
				}
			}
			if (result > M) {
				max = center - 1;
			} else {
				answer = center;
				min = center + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;
		System.out.println(solution(budgets, M));

	}

}
