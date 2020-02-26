package n진수게임;

import java.util.*;

public class Solution {
	public static String solution(int n, int t, int m, int p) {
		char[] arr = new char[t * m];
		arr[0] = '0';
		int num = 1;
		int index = 1;
		while (index < arr.length) {
			char[] converted = convert(num, n);
			for (char c : converted) {
				if (index > arr.length - 1){
					break;
				}else{
					arr[index] = c;
					index++;
				}
			}
			num++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = p-1; i < arr.length; i+=m) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static char[] convert(int num, int n) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int rest = num % n;
			if(rest >= 10){
				sb.append(String.valueOf((char) ('A' + (rest - 10))));
			}else{
				sb.append(rest);
			}
			num = num/n;
		}
		return sb.reverse().toString().toCharArray();
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));
	}

}
