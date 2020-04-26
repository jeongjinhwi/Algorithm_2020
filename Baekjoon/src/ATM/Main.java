package ATM;
import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long list[] = new long[N];
		long time[] = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		long time_result = 0;
		long answer = 0;
		for(int i = 0; i < N; i++){
			time_result += list[i];
			time[i] = time_result;
		}
		for(int i = 0; i < N; i++){
			answer += time[i];
		}
		System.out.println(answer);
	}
}
