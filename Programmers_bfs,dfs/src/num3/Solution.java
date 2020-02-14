package num3;

import java.util.*;

public class Solution {
	static int answer = 0;
	static boolean[] visited;

	public static int solution(String begin, String target, String[] words) {
		ArrayList<String> data = new ArrayList<String>();
		visited = new boolean[words.length];
		for (String i : words) {
			data.add(i);
		}
		if (!data.contains(target)) {
			return answer;
		} else {
			dfs(begin, target, data, 0);
		}
		return answer;
	}

	public static void dfs(String begin, String target, ArrayList<String> data, int index) {
		String split_words = begin;
		int correct_count = 0;
		int target_count = 0;
		String next_words;
		if (!begin.equals(target)) {
			for (int j = index; j < data.size(); j++) {
				target_count = 0;
				correct_count = 0;
				next_words = data.get(j);
				for (int i = 0; i < split_words.length(); i++) {
					if (split_words.charAt(i) == next_words.charAt(i)) {
						correct_count++;
					}
					if (split_words.charAt(i) == target.charAt(i)) {
						target_count++;
					}
				}
				if ((target_count == split_words.length() - 1) && index < data.size() && visited[index] == false) {
					answer++;
					visited[index] = true;
					return;
				}
				if ((correct_count == split_words.length() - 1) && index < data.size() && visited[index] == false) {
					answer++;
					visited[index] = true;
					dfs(next_words, target, data, index + 1);
				} else if ((correct_count != split_words.length() - 1) && index < data.size()
						&& visited[index] == false) {
					visited[index] = true;
					dfs(split_words, target, data, index + 1);
				}
			}
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String begin = "hit";
		String target = "cog";
		String[] words1 = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words2 = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(solution(begin, target, words2));
	}

}
