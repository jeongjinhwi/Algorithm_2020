package num7;

import java.util.*;

public class solution {
	public static int solution(int[] weight) {
		int answer = 1;
		//�ʱ⿡ 1�� �����ν� weight���Ѱ͵�+1�� ������ �� �ִ��� üũ�Ѵ�. 
		Arrays.sort(weight);
		for (int i : weight) {
			if(answer < i){
				break;
			}
			answer += i;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int[] weight = { 3, 1, 6, 2, 7, 30, 1 };
		System.out.println(solution(weight));
	}
}
