import java.util.*;
import java.io.*;

public class Main1 {
	static int N, K;
	static String data;
	static long max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N >= 1 && N <= 100000 && K >= 1 && K <= 10 && K <= N) {
			st = new StringTokenizer(br.readLine());
			data = st.nextToken();
			for (int i = 0; i < N - K + 1; i++) {
				String str_temp = data.substring(i, K + i);
				max = Math.max(max, Long.parseLong(str_temp));
			}
			System.out.println(max);
		} else {
			return;
		}
	}

}
