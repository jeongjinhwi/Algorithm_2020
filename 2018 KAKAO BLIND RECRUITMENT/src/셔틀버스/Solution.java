package 셔틀버스;

import java.util.*;

public class Solution {
	public static String solution(int n, int t, int m, String[] timetable) {
		//수정 필요 아직 
		String answer = "";
		ArrayList<Integer> time = new ArrayList<>();
		ArrayList<Integer> bus_time = new ArrayList<>();
		int hour = 0;
		int minute = 0;
		int max = 2359;
		int start_bus = 900;
		int result_bus_time = start_bus;
		int add_hour = 0;
		for (int i = 0; i < n; i++) {
			hour = result_bus_time / 100;
			add_hour = (result_bus_time % 100) / 60;
			hour = (hour + add_hour) % 24;
			minute = (result_bus_time % 100) % 60;
			bus_time.add((hour * 100) + minute);

			result_bus_time = result_bus_time + t;
		}
		for (int i = 0; i < timetable.length; i++) {
			String[] temp = timetable[i].split(":");
			hour = Integer.parseInt(temp[0]) * 100;
			minute = Integer.parseInt(temp[1]);
			time.add(hour + minute);
		}
		time.sort(null);
		
		//조건문 수정 필요
		for (int i = 0; i < bus_time.size(); i++) {
			int m_count = 0;
			if(time.size() > 1){
				for (int j = 0; j < time.size(); j++) {
					if(m_count == m){
						break;
					}else if(time.get(j) <= bus_time.get(i)){
						m_count++;
						time.remove(j);
						j = j-1;
					}
				}
			}else{
				
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = { "08:00", "08:01", "08:02", "08:03" };
		System.out.println(solution(n, t, m, timetable));

	}

}
