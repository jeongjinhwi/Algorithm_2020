package num5;
import java.util.*;
public class Solution {
	public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stick = new Stack<>();	//후입선출 -> 나중에 들어간것이 먼저 나온다.

        for (int i = 0; i < arrangement.length(); i++) {	//()이 나오면 레이저, 닫히지 않으면 막대기가 추가 생성
            if (arrangement.charAt(i) == '(')		//(이 나오면 스택에 차례대로 삽입
                stick.add(arrangement.charAt(i));
            else if(arrangement.charAt(i) == ')'){		
                stick.pop();
                if (arrangement.charAt(i-1) == '(')		//이전이 (이고 현재가 )이면 레이저 생성
                    answer+=stick.size();
                else if(arrangement.charAt(i) == ')'){
                    answer++;
                }
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}

}
