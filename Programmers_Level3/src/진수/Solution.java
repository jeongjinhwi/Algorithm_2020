package Áø¼ö;
import java.util.*;
public class Solution {
	public static String solution(String rule, String A, String B){
		String answer = "";
		char []split = rule.toCharArray();
		int jinsu = rule.length();
		String A_jin = "";
		String B_jin = "";
		
		for(int i = 0; i < A.length(); i++){
			for(int j = 0; j < split.length; j++){
				if(A.charAt(i) == split[j]){
					A_jin += String.valueOf(j);
				}
			}
		}
		
		for(int i = 0; i < B.length(); i++){
			for(int j = 0; j < split.length; j++){
				if(B.charAt(i) == split[j]){
					B_jin += String.valueOf(j);
				}
			}
		}
		int temp = Integer.parseInt(A_jin)-Integer.parseInt(B_jin);
		String result = String.valueOf(temp);
		char[] result_split = result.toCharArray();
		
		for(int i = 0; i < result_split.length; i++){
			int z = (result_split[i]-'0') % jinsu;
			answer+=String.valueOf(split[z]);
					
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String rule = "zxcvadr";
		String A = "avz";
		String B = "xc";
		
		System.out.println(solution(rule, A, B));
	}
}
