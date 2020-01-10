package num3;
import java.util.*;

public class Solution {
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        Queue<Integer> prog = new LinkedList<Integer>();
        Queue<Integer> spee = new LinkedList<Integer>();
        
        
        for(int i = 0; i < progresses.length; i++){
        	prog.add(progresses[i]);
        	spee.add(speeds[i]);
        }
        
        int pre_day = 0;
        while(!prog.isEmpty() && !spee.isEmpty()){
        	int fuc = prog.poll();
        	int per = spee.poll();
        	int day = 0;
        	int data = fuc + (per*day);
        	
        	while(!(data >= 100)){
        		day++;
        		data = fuc + (per*day);
        	}
        	if(pre_day > day){
        		day = pre_day;
        	}else{
        		pre_day = day;
        	}
        	answer[day]++;
        	
        }
        ArrayList<Integer> temp_answer = new ArrayList<>();
        for(int i = 0; i<answer.length; i++){
        	if(answer[i] != 0){
        		temp_answer.add(answer[i]);
        	}
        }
        
        answer = new int[temp_answer.size()];
        for(int i = 0; i<temp_answer.size(); i++){
        	answer[i] = temp_answer.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] pro = {93,30,55};
		int[] spe = {1,30,5};
		System.out.println(solution(pro,spe));
	}

}
