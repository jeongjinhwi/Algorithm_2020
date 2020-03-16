package 로또;

import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int[] S;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = 1;
		while (!(k == 0)) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			int pick_count = 6;
			// bfs탐색
			// 6개를 뽑아야 함
			visited = new boolean[k];
//			System.out.println();
			dfs(0, pick_count);
			System.out.println();
		}

	}

	public static void dfs(int start, int cnt) {
		if (cnt == 0) {
			for (int i = 0; i < k; i++) {
				if (visited[i] == true) {
					System.out.print(S[i] + " ");
				}
			}
			System.out.println();
		}
		for (int i = start; i < k; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				dfs(i, cnt - 1);
				visited[i] = false;
			}
		}

	}

}
