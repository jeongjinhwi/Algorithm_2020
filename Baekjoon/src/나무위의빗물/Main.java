package 나무위의빗물;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double W = Integer.parseInt(st.nextToken());
		int[] data = new int[500001];
		double count = 0;
		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			data[Integer.parseInt(st.nextToken())]++;
			data[Integer.parseInt(st.nextToken())]++;
		}
		for (int i = 2; i <= N; i++) {
			if (data[i] == 1) {
				count++;
			}
		}
		System.out.print( String.format("%.10f", W / count));

	}
}
