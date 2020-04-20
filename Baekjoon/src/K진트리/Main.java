package K진트리;

import java.util.*;
import java.io.*;

public class Main {
	static int K, Q;
	static long N, x, y;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			long answer = 0;
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			long temp1 = Math.min(x, y);
			long temp2 = Math.max(x, y);
			x = temp1;
			y = temp2;
			if (K == 1) {
				answer = Math.abs(x - y);
			} else {
				while (x != y) {
					if (x < y) {
						y = ((y - 2) / K) + 1;
						answer++;
					} else {
						x = ((x - 2) / K) + 1;
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
