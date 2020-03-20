package 전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int loop = Integer.parseInt(st.nextToken());
		// HashMap<K, V>
		ArrayList<String> list;
		for (int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			int loop2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j < loop2; j++) {
				st = new StringTokenizer(br.readLine());
				list.add(st.nextToken());
			}
			check(list);
		}

	}

	public static void check(ArrayList<String> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i+1).startsWith(list.get(i))) {
				System.out.println("NO");
				return;
			}

		}
		System.out.println("YES");
	}

}
