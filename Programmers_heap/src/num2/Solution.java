package num2;
import java.util.*;

public class Solution {
	 public static int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        Queue<Integer> flour = new PriorityQueue<Integer>(Comparator.reverseOrder());	//�ִ� ��
	        
	        int index = 0;
	        for(int i = 0; i<k; i++){
	        	 if(index < dates.length && i == dates[index]){
	                 flour.add(supplies[index]);
	                 index++;
	        	 }

	             if(stock == 0) {
	                 stock += flour.poll();
	                 answer++;
	             }
	             stock -= 1;
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int st = 4;						//���忡 �����ִ� �а��� ����
		int[] date = {4,10,15};			//�а��� ��������
		int[] sup = {20,5,10};			//�ش� ������ ���� ������ �а��� ����
		int k = 30;						//���� �������� ���� ���޹��� �� �ִ� ����
		System.out.println(solution(st, date, sup, k));
		
	}

}
