package 模备匙飘况农;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 磊悼 积己等 皋家靛 胶庞
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		HashSet<String> friends;
		HashSet<String> friends2;
		int loop = Integer.parseInt(st.nextToken());
		for (int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			int loop2 = Integer.parseInt(st.nextToken());
			friends = new HashSet<>();
			for (int j = 0; j < loop2; j++) {
				st = new StringTokenizer(br.readLine());
				friends2 = new HashSet<>();
				if (j == 0) {
					friends.add(st.nextToken().toLowerCase());
					friends.add(st.nextToken().toLowerCase());
					System.out.println(friends.size());
				} else {
					String t1 = st.nextToken().toLowerCase();
					String t2 = st.nextToken().toLowerCase();
					int size = friends.size();
					friends.add(t1);
					friends.add(t2);
					friends2.add(t1);
					friends2.add(t2);
					
					if (friends.size() - friends2.size() == size) {
						System.out.println(friends2.size());
					} else {
						System.out.println(friends.size());
					}
				}
			}
		}
	}

}
