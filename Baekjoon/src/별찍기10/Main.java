package 별찍기10;

import java.util.*;
import java.io.*;

public class Main {
	static char star[][];

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		star = new char[N][N];

		for (int i = 0; i < star.length; i++) {
			Arrays.fill(star[i], ' ');
		}

		point(0, 0, N);
		for (int i = 0; i < star.length; i++) {
			System.out.println(star[i]);
		}
	}

	public static void point(int x, int y, int N) {
		int p = 0;
		if (N == 1) {
			star[x][y] = '*';
			return;
		}
		p = N / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				point(x + (p * i), y + (p * j), p);
			}
		}
	}

}
