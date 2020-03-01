package 자동완성;

import java.util.*;

public class Solution {
	public static int solution(String[] words) {	//22개중 7개에서 실행초과 에러 발생
		int answer = 0;
		Arrays.sort(words);
		for (String str : words) {
			for (int j = 1; j < str.length() + 1; j++) {
				int similar_word = 0;
				String ch = str.substring(0, j);
				answer ++;
                int next_word = 0;
				for(String tar : words){
					
					if(tar.startsWith(ch)){
						similar_word++;
						next_word++;
					}
					if(next_word >= 2){
						break;
					}
				}
				if (similar_word == 1) { // 1개가 나올때
					break;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] words = { "word", "war", "warrior", "world" };
		System.out.println(solution(words));
	}
}
