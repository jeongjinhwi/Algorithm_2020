package num4;

import java.util.*;

public class Solution {
	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		
		int i = 0;
		int j = 0;
		for (i = people.length -1; i > j; i--) {	//1�� ������ 2�� ������ �Ǵ�
			if(people[i] + people[j] <= limit){		//2�� ������
				j++;
				answer++;
			}else{									//1�� ������
				answer++;
			}
		}
		if(i == j) answer++;

		return answer;
	}

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int[] peo = { 70,50,80,50 };		//60,40,60,40
		int li = 100;
		System.out.println(solution(peo, li));
	}

}
