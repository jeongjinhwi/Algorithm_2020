package num7;

import java.util.*;

public class solution {
	public static int solution(int[] weight) {
		int answer = 1;
		//초기에 1로 줌으로써 weight더한것들+1을 측정할 수 있는제 체크한다. 
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
		// TODO 자동 생성된 메소드 스텁
		int[] weight = { 3, 1, 6, 2, 7, 30, 1 };
		System.out.println(solution(weight));
	}
}
