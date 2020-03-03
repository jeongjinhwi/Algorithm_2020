package ����ä�ù�;
import java.util.*;
public class Solution {
	public static String[] solution(String[] record) {
		String[] answer = {};
		HashMap<String, String> list = new HashMap<>();
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < record.length; i++){
			String[] split = record[i].split(" ");
			if(split[0].equals("Enter")){
				if(list.containsKey(split[1])){	//���ԵǾ� �ִ� ���
					list.replace(split[1], split[2]);
				}else if(!list.containsKey(split[1])){
					list.put(split[1], split[2]);
				}
			}else if(split[0].equals("Change")){
				list.replace(split[1], split[2]);
			}
		}
		for(int i = 0; i < record.length; i++){
			StringBuilder sb = new StringBuilder();
			String[] split = record[i].split(" ");
			if(split[0].equals("Enter")){
				sb.append(list.get(split[1])).append("���� ���Խ��ϴ�.");
				result.add(sb.toString());
			}else if(split[0].equals("Leave")){
				sb.append(list.get(split[1])).append("���� �������ϴ�.");
				result.add(sb.toString());
			}
		}
		answer = new String[result.size()];
		for(int i = 0; i < result.size(); i++){
			answer[i] = result.get(i);
		}
        
        return answer;
    }
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
}
