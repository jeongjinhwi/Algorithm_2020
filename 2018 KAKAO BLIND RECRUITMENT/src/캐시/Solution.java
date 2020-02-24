package 캐시;

import java.util.*;

public class Solution {
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		// Stack<String> list = new Stack<>();
		ArrayList<String> list = new ArrayList<>();

		if (cacheSize == 0) {
			return 5 * cities.length;
		}
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toUpperCase();
		}
		for (int i = 0; i < cities.length; i++) {
			if (list.contains(cities[i]) == true) { // hit
				list.remove(cities[i]);
				list.add(cities[i]);
				answer += 1;
			} else if (list.contains(cities[i]) == false) { // miss
				if (list.size() < cacheSize) {
					list.add(cities[i]);
					answer += 5;
				}else{
					list.remove(0);
					list.add(cities[i]);
					answer += 5;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
				"Jeju", "NewYork", "Rome" };
		int cacheSize = 5;
		System.out.println(solution(cacheSize, cities));
	}

}
