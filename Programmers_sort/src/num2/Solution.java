package num2;
import java.util.*;
public class Solution {
	public static String solution(int[] numbers) {
		String answer = "";
		String[] num = new String[numbers.length];
		for(int i = 0; i<num.length; i++){
			num[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(num,(o1,o2)->(o2+o1).compareTo(o1+o2));	//sort이 부분 더 공부해볼것 내림차순
		if(num[0].equals("0")){
			return "0";
		}else{
			for(String i : num){
				answer = answer+i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] num = { 6, 10, 2 };
		System.out.println(solution(num));
	}

}
