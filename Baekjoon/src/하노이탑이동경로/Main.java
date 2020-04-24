package 하노이탑이동경로;
import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		hanoi(N, 1, 2, 3);
		System.out.println((int)Math.pow(2, N)-1);
		System.out.println(sb);
	}
	public static void hanoi(int n, int from, int by, int to){
		if(n == 1){
			sb.append(from+" "+to+"\n");
			return;
		}
		hanoi(n-1, from, to, by);
		sb.append(from+" "+to+"\n");
		hanoi(n-1, by, from, to);
	}

}
