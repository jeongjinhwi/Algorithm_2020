package num1;
import java.util.*;
public class Solution {
	public static int[] solution(int[] answers) {
//		1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//		2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//		3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        int[] answer = {};
//        int[] give_up1 = new int[answers.length];	//1���� 5���� ������� ����
//        int[] give_up2 = new int[answers.length];	//2, 1, 2, 3, 2, 4, 2, 5 ������� �ݺ�
//        int[] give_up3 = new int[answers.length];	//3, 3, 1, 1, 2, 2, 4, 4, 5, 5 ������� �ݺ�
        
        int correct1 = 0;
        int correct2 = 0;
        int correct3 = 0;
        //int[] correct = new int[answer.length];
        int[] loop_g1 = {1, 2, 3, 4, 5};
        int[] loop_g2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] loop_g3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
       
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(int i = 0; i<answers.length; i++){
        	/*****1�� ������********/
        	if(loop_g1[i%loop_g1.length] == answers[i]){
        		correct1++;
        	}
        	
        	/*******2�� ������*******/
        	if(loop_g2[i%loop_g2.length] == answers[i]){
        		correct2++;
        	}
        	
        	/*******3�� ������*******/
        	if(loop_g3[i%loop_g3.length] == answers[i]){
        		correct3++;
        	}
        	
        }
       
        int max = Math.max(Math.max(correct1, correct2),correct3); // max�� ���ϱ�
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==correct1){
        	list.add(1); 
        }
        if(max==correct2){ 
        	list.add(2);
        }
        if(max==correct3){
        	list.add(3);
        }
        
        answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int[] an = {1,2,3,4,5};
		System.out.println(solution(an));
	}

}
