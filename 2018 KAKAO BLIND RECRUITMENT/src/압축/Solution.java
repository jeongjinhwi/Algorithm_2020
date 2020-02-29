package 압축;

import java.util.*;

public class Solution {
	public static int[] solution(String msg) {
		int[] answer = {};
		ArrayList<String> word = new ArrayList<>();
		ArrayList<Integer> answer_list = new ArrayList<>();
		word.add("empty");
		for (char i = 'A'; i <= 'Z'; i++) {
			word.add(Character.toString(i));
		}
		String data = Character.toString(msg.charAt(0));
		for (int i = 0; i < msg.length(); i++) {
				if(word.contains(msg.substring(i, msg.length()))){
					answer_list.add(word.indexOf(msg.substring(i, msg.length())));
					break;
				}
			for (int j = i + 1; j < msg.length(); j++) {
				String next_data = msg.substring(i, j+1);
				if (word.contains(data) && !word.contains(next_data)) {
					word.add(next_data);
					i = j-1;
					answer_list.add(word.indexOf(data));
					data = Character.toString(msg.charAt(i+1));
					break;
				} else if (word.contains(data) && word.contains(next_data)) {
					data = msg.substring(i, j+1);
					continue;
				}
			}
		}
		answer = new int[answer_list.size()];
		for(int i = 0; i < answer_list.size(); i++){
			answer[i] = answer_list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		int[] result = solution(msg);
		for(int i : result){
			System.out.println(i);
		}
	}

}
