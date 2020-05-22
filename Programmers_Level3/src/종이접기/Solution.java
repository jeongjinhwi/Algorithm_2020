package 종이접기;
import java.util.*;

public class Solution {
	public static int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        list.add(0);
        if(n == 1){
        	answer = new int[1];
        	answer[0] = 0;
        	return answer;
        }
        
        for(int i = 1; i < n; i++){
        	for(int j = 0; j < list.size(); j++){
        		list2.add(list.get(j));
        	}
        	list2.add(0);
        	for(int j = list.size()-1; j >= 0; j--){
        		if(list.get(j) == 0){
        		list2.add(1);
        		}else{
        		list2.add(0);
        		}
        	}
        	list = list2;
        	list2 = new ArrayList<>();
        }
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 4;
		solution(n);
	}

}
