package 회의실배정;
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
		long time[][] = new long[N][2];
		int answer = 0;
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			time[i][0] = Long.parseLong(st.nextToken());
			time[i][1] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1] == o2[1]){
				return Long.compare(o1[0], o2[0]);
			}else{
				return Long.compare(o1[1], o2[1]);
			}
		});
		
        long end = -1;    
        for (int i = 0; i < N; i++) {
            if (time[i][0] >= end) {
                end = time[i][1];    
                answer++;
            }
        }
		
		System.out.println(answer);

	}

}