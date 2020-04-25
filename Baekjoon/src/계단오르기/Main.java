package 계단오르기;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int stairs[] = new int[N];
		int result[] = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}

		if (N > 3) {
			result[0] = stairs[0];
			result[1] = stairs[0] + stairs[1];
			result[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
			for (int i = 3; i < N; i++) {
				result[i] = Math.max(result[i - 2] + stairs[i], result[i - 3] + stairs[i - 1] + stairs[i]);
			}
			System.out.println(result[N-1]);
		} else if (N == 1) {
			System.out.println(stairs[0]);
		} else if (N == 2) {
			System.out.println(stairs[0] + stairs[1]);
		} else if (N == 3) {
			System.out.println(Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]));
		}
	}

}
