package num1;

import java.util.*;

public class Solution {
	static int answer = 0;

	public static int solution(int[] numbers, int target) { // dfs�� ����, ����Լ�,
															// bfs�� ť��
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
		// TODO �ڵ� ������ �޼ҵ� ����
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

}
