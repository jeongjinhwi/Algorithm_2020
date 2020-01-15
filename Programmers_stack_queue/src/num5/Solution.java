package num5;
import java.util.*;
public class Solution {
	public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stick = new Stack<>();	//���Լ��� -> ���߿� ������ ���� ���´�.

        for (int i = 0; i < arrangement.length(); i++) {	//()�� ������ ������, ������ ������ ����Ⱑ �߰� ����
            if (arrangement.charAt(i) == '(')		//(�� ������ ���ÿ� ���ʴ�� ����
                stick.add(arrangement.charAt(i));
            else if(arrangement.charAt(i) == ')'){		
                stick.pop();
                if (arrangement.charAt(i-1) == '(')		//������ (�̰� ���簡 )�̸� ������ ����
                    answer+=stick.size();
                else if(arrangement.charAt(i) == ')'){
                    answer++;
                }
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}

}
