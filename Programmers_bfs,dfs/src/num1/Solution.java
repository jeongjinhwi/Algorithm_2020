package num1;

import java.util.*;

public class Solution {
	static int answer = 0;

	public static int solution(int[] numbers, int target) { // dfs는 스택, 재귀함수,
															// bfs는 큐로
		dfs(numbers, target, 0);
		return answer;
	}

	public static void dfs(int[] numbers, int target, int index) {
		if (index == numbers.length) {
			int data = 0;
			for (int i = 0; i < numbers.length; i++) {
				data += numbers[i];
			}
			if (data == target) {
				answer++;
			}
		} else {
			numbers[index] = numbers[index];
			dfs(numbers, target, index + 1);
			numbers[index] = numbers[index] * -1;
			dfs(numbers, target, index + 1);
		}
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

}
