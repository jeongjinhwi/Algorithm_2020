package Ÿ�ϸ�2XN;
import java.util.*;
public class Solution {
	public static int solution(int n) {
        int answer = 0;
        
        int pre = 1;
        int afe = 1;
        for(int i = 0; i < n-1; i++){
        	int temp = (pre+afe) % 1000000007;
        	pre = afe;
        	afe = temp;
        }
        answer = afe;
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int n = 4;
		System.out.println(solution(n));
	}

}
